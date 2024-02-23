package com.example.dingding.service;


import com.alibaba.fastjson.JSON;
import com.example.dingding.utils.HttpUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class TestServiceImpl implements TestService {

    private static final String MSG_URL = "https://oapi.dingtalk.com/robot/send?access_token=13de22b6b2d82b773e5c2dec3da6fdf8d10b17e284907cba46eb306e39956f90";

    @Override
    public void test() {
        int i = 1 / 0;
    }

    @Override
    public void Weather() {
        try{
            URL url = new URL("http://t.weather.itboy.net/api/weather/city/101230201");
            InputStreamReader isReader =  new InputStreamReader(url.openStream(),"UTF-8");//“UTF- 8”万国码，可以显示中文，这是为了防止乱码
            BufferedReader br = new BufferedReader(isReader);//采用缓冲式读入
            String str;
            while((str = br.readLine()) != null){
                String regex="\\p{Punct}+";
                String digit[]=str.split(regex);
                String Weather = '\n'+"城市:"+digit[22]+digit[18]+
                        '\n'+"时间:"+digit[49]+"年"+digit[50]+"月"+digit[51]+"日"+digit[53]+
                        '\n'+"温度:"+digit[47]+"~"+digit[45]+
                        '\n'+"天气:"+digit[67]+" "+digit[63]+digit[65]+
                        '\n'+digit[69];
                System.out.println(Weather);
            }
            br.close();//网上资源使用结束后，数据流及时关闭
            isReader.close();
        }
        catch(Exception exp){
            System.out.println(exp);
        }
    }

    /**
     * 发送消息
     *
     * @param content    通知内容
     * @param isAtAll    是否@所有人
     * @param mobileList 通知具体人的手机号码列表
     */
    private static void sendDingTalkMsg(boolean isAtAll, List<String> mobileList, String content) {
        try {
            if (!CollectionUtils.isEmpty(mobileList)) {
                isAtAll = false;
            }
            //消息内容
            Map<String, String> contentMap = new HashMap<>();
            contentMap.put("content", content);

            //通知人
            Map<String, Object> atMap = new HashMap<>();
            //1.是否通知所有人
            atMap.put("isAtAll", isAtAll);
            //2.通知具体人的手机号码列表
            atMap.put("atMobiles", mobileList);

            Map<String, Object> parameter = new HashMap<>();
            parameter.put("msgtype", "text");
            parameter.put("at", atMap);
            parameter.put("text", contentMap);

            //推送消息（http请求）
            String result = HttpUtils.post(MSG_URL, JSON.toJSONString(parameter));
            log.info("发送钉钉消息-result:{}", result);
        } catch (Exception e) {
            log.error("发送钉钉消息异常", e);
        }
    }



}
