package com.example.dingding.controller;

import com.alibaba.fastjson.JSON;
import com.example.dingding.utils.HttpUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.CollectionUtils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 钉钉-工具类
 */
@Slf4j
public class DingTalkUtil {

    /**
     * 钉钉机器人发消息地址（配置机器人的webhook）
     * 此处大家可以配置到配置文件等等方式
     */
    private static final String MSG_URL = "https://oapi.dingtalk.com/robot/send?access_token=13de22b6b2d82b773e5c2dec3da6fdf8d10b17e284907cba46eb306e39956f90";

    /**
     * 通知具体人
     *
     * @param content    通知内容
     * @param mobileList 通知具体人的手机号码列表
     */
    public static void sendDingTalkMsg(List<String> mobileList, String content) {
        sendDingTalkMsg(false, mobileList, content);
    }

    /**
     * 通知所有人
     *
     * @param content 通知内容
     */
    public static void sendDingTalkMsg(String content) {
        sendDingTalkMsg(false, null, content);
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
//            atMap.put("isAtAll", isAtAll);
            //2.通知具体人的手机号码列表
//            atMap.put("atMobiles", mobileList);

            Map<String, Object> parameter = new HashMap<>();
            parameter.put("msgtype", "text");
            parameter.put("at", atMap);
            parameter.put("text", contentMap);
            parameter.put("jg","警告：");

            //推送消息（http请求）
            String result = HttpUtils.post(MSG_URL, JSON.toJSONString(parameter));
            log.info("提醒：发送钉钉消息-result:{}", result);
        } catch (Exception e) {
            log.error("提醒：发送钉钉消息异常", e);
        }
    }

    public static void main(String[] args) {
//        sendDingTalkMsg("服务通知:测试消息");



        String Weather = "";
        try {
            URL url = new URL("http://t.weather.itboy.net/api/weather/city/101230201");
            InputStreamReader isReader = new InputStreamReader(url.openStream(), "UTF-8");//“UTF- 8”万国码，可以显示中文，这是为了防止乱码
            BufferedReader br = new BufferedReader(isReader);//采用缓冲式读入
            String str;
            while ((str = br.readLine()) != null) {
                String regex = "\\p{Punct}+";
                String digit[] = str.split(regex);
                Weather = "\n\n" + "城市:" + digit[22] + digit[18] +
                        "\n\n" + "时间:" + digit[49] + "年" + digit[50] + "月" + digit[51] + "日" + digit[53] +
                        "\n\n" + "温度:" + digit[47] + "~" + digit[45] +
                        "\n\n" + "天气:" + digit[67] + " " + digit[63] + digit[65] +
                        "\n\n" + digit[69];
                System.out.println(Weather);
            }
            br.close();//网上资源使用结束后，数据流及时关闭
            isReader.close();
        } catch (Exception exp) {
            System.out.println(exp);
        }
        sendDingTalkMsg(Collections.singletonList("13665055919"), "提醒:"+Weather);
    }
}