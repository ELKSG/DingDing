package com.example.dingding.controller;

import com.dingtalk.api.DefaultDingTalkClient;
import com.dingtalk.api.DingTalkClient;
import com.dingtalk.api.request.OapiRobotSendRequest;
import com.dingtalk.api.response.OapiRobotSendResponse;
import com.taobao.api.ApiException;
import lombok.SneakyThrows;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.stereotype.Component;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Collections;

@Component
public class DingDing {

    public OapiRobotSendResponse sendMsg(String stackTraceString) throws ApiException {
        String qm = qm();
        // 前面复制的机器人 Webhook 地址，放进来，后面加上签名
        DingTalkClient client = new DefaultDingTalkClient("https://oapi.dingtalk.com/robot/send?access_token=13de22b6b2d82b773e5c2dec3da6fdf8d10b17e284907cba46eb306e39956f90" + qm + "");

        OapiRobotSendRequest request = new OapiRobotSendRequest();
        request.setMsgtype("text");
        OapiRobotSendRequest.Text text = new OapiRobotSendRequest.Text();
        text.setContent("提醒：" + stackTraceString + "");
        request.setText(text);
        OapiRobotSendRequest.At at = new OapiRobotSendRequest.At();
        at.setAtMobiles(Collections.singletonList("136XXXXXXXX"));


        // isAtAll类型如果不为Boolean，请升级至最新SDK
//      at.setIsAtAll(true);
//      at.setAtUserIds(Arrays.asList("109929","32099"));
//      request.setAt(at);

//      request.setMsgtype("link");
//      OapiRobotSendRequest.Link link = new OapiRobotSendRequest.Link();
//      link.setMessageUrl("https://www.dingtalk.com/");
//      link.setPicUrl("");
//      link.setTitle("时代的火车向前开");
//      link.setText("提醒: 这个即将发布的新版本，创始人xx称它为红树林。而在此之前，每当面临重大升级，产品经理们都会取一个应景的代号，这一次，为什么是红树林");
//      request.setLink(link);

//      request.setMsgtype("markdown");
//      OapiRobotSendRequest.Markdown markdown = new OapiRobotSendRequest.Markdown();
//      markdown.setTitle("杭州天气");
//      markdown.setText("提醒: #### 杭州天气 @156xxxx8827\n" +
//              "> 9度，西北风1级，空气良89，相对温度73%\n\n" +
//              "> ![screenshot](https://gw.alicdn.com/tfs/TB1ut3xxbsrBKNjSZFpXXcXhFXa-846-786.png)\n"  +
//              "> ###### 10点20分发布 [天气](http://www.thinkpage.cn/) \n");
//      request.setMarkdown(markdown);

//        request.setMsgtype("markdown");
//        OapiRobotSendRequest.Markdown markdown = new OapiRobotSendRequest.Markdown();
//        markdown.setTitle("提醒:厦门天气");
//        String Weather = "";
//        try{
//            URL url = new URL("http://t.weather.itboy.net/api/weather/city/101230201");
//            InputStreamReader isReader =  new InputStreamReader(url.openStream(),"UTF-8");//“UTF- 8”万国码，可以显示中文，这是为了防止乱码
//            BufferedReader br = new BufferedReader(isReader);//采用缓冲式读入
//            String str;
//            while((str = br.readLine()) != null){
//                String regex="\\p{Punct}+";
//                String digit[]=str.split(regex);
//                Weather = "\n\n"+"城市:"+digit[22]+digit[18]+
//                        "\n\n"+"时间:"+digit[49]+"年"+digit[50]+"月"+digit[51]+"日"+digit[53]+
//                        "\n\n"+"温度:"+digit[47]+"~"+digit[45]+
//                        "\n\n"+"天气:"+digit[67]+" "+digit[63]+digit[65]+
//                        "\n\n"+digit[69];
//                System.out.println(Weather);
//            }
//            br.close();//网上资源使用结束后，数据流及时关闭
//            isReader.close();
//        }
//        catch(Exception exp){
//            System.out.println(exp);
//        }
//        markdown.setText(Weather);
//        request.setMarkdown(markdown);
        return client.execute(request);
    }

    @SneakyThrows
    public static String qm() {
        Long timestamp = System.currentTimeMillis();
        String secret = "this is secret";
        String stringToSign = timestamp + "\n" + secret;
        Mac mac = Mac.getInstance("HmacSHA256");
        mac.init(new SecretKeySpec(secret.getBytes(StandardCharsets.UTF_8), "HmacSHA256"));
        byte[] signData = mac.doFinal(stringToSign.getBytes(StandardCharsets.UTF_8));
        String sign = URLEncoder.encode(new String(Base64.encodeBase64(signData)), "UTF-8");
        System.out.println(sign);
        return "&timestamp=" + timestamp + "&sign=" + "" + "";
    }
}
