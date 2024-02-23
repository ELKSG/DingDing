package com.example.dingding.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.dingding.entity.One;
import com.example.dingding.entity.Three;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import static com.example.dingding.controller.DingTalkUtil.sendDingTalkMsg;

@Slf4j
@Component
@RequestMapping("/zw/")
public class TaskController {

    // 钉钉发送天气
    @Scheduled(cron = "0 0 8 * * ?")
//    @Scheduled(cron = "0 */1 * * * ?")
    public void myTask() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(simpleDateFormat.format(new Date()));

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
        sendDingTalkMsg(Collections.singletonList("13665055919"), "提醒:厦门天气" + Weather);
    }

    private static HttpURLConnection con;

    // 钉钉发送热搜
    @Scheduled(cron = "0 */60 * * * ?")
//    @Scheduled(cron = "0 */1 * * * ?")
    public void myTasks() {
        String hotSearch = getHot();
        sendDingTalkMsg(Collections.singletonList("13665055919"), "提醒:热搜" + hotSearch);
    }

    private static String getHot() {
        StringBuffer content = new StringBuffer();
        try {
            URL url = new URL("https://weibo.com/ajax/statuses/hot_band");
            con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            in.close();
            con.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
        JSONObject jsonObject = JSON.parseObject(content.toString());
        One javaObject = JSON.toJavaObject(jsonObject, One.class);
        List<Three> bandList = javaObject.getData().getBand_list();
        String hotSearch = "";
        int num = 0;
        for (int i = 0; i < bandList.size(); i++) {
            num = num + 1;
            try {
//                String searchUrl = "https://s.weibo.com/weibo?q=%23"+ URLEncoder.encode(bandList.get(i).getNote(),"utf-8")+"%23";
//                String searchUrl = "https://s.weibo.com/weibo?q=%23"+ bandList.get(i).getNote()+"%23";
//                hotSearch = hotSearch + "\n" + num + "、" + bandList.get(i).getNote() + " ("+bandList.get(i).getRaw_hot()+")" +searchUrl;
                hotSearch = hotSearch + "\n" + num + "、" + bandList.get(i).getNote() + "(" + bandList.get(i).getCategory() + "-" + bandList.get(i).getRaw_hot() + ")";
//                hotSearch = hotSearch + num + "、" + bandList.get(i).getNote();
//                hotSearch = "https://s.weibo.com/weibo?q=%23"+ URLEncoder.encode(bandList.get(i).getNote(),"utf-8")+"%23";
                if (i == 20) {
                    break;
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        return hotSearch;
    }


    @Scheduled(cron = "0 0 11 * * ?")
    public void order() {
        sendDingTalkMsg(Collections.singletonList("13665055919"), "提醒:点餐啦");
    }

//    @Scheduled(cron = "0 5 11 * * ?")
//    public void orders() {
//        // 获取热搜
//        String hotSearch = getHotWX();
//        StringBuffer content = new StringBuffer();
//        try {
//            String random = System.currentTimeMillis() + String.valueOf((int) (Math.random() * 100));
//            URL url = new URL("http://push.ijingniu.cn/send?key=e8e8d2efda364a79b3797da2525c5f5e&head=zw&body=点餐啦" + hotSearch);
//            con = (HttpURLConnection) url.openConnection();
//            con.setRequestMethod("POST");
//            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
//            String inputLine;
//            while ((inputLine = in.readLine()) != null) {
//                content.append(inputLine);
//            }
//            in.close();
//            con.disconnect();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }


//    private static String getHotWX() {
//        StringBuffer content = new StringBuffer();
//        try {
//            URL url = new URL("https://weibo.com/ajax/statuses/hot_band");
//            con = (HttpURLConnection) url.openConnection();
//            con.setRequestMethod("GET");
//            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
//            String inputLine;
//            while ((inputLine = in.readLine()) != null) {
//                content.append(inputLine);
//            }
//            in.close();
//            con.disconnect();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        JSONObject jsonObject = JSON.parseObject(content.toString());
//        One javaObject = JSON.toJavaObject(jsonObject, One.class);
//        List<Three> bandList = javaObject.getData().getBand_list();
//        String hotSearch = "";
//        int num = 0;
//        for (int i = 0; i < bandList.size(); i++) {
//            num = num + 1;
//            try {
////                hotSearch = "https://s.weibo.com/weibo?q=%23"+ URLEncoder.encode(bandList.get(i).getNote(),"utf-8")+"%23";
//                hotSearch = hotSearch + "\n" + num + "、" + bandList.get(i).getNote() + "(" + bandList.get(i).getCategory() + "-" + bandList.get(i).getRaw_hot() + ")";
//                if (i == 20) {
//                    break;
//                }
//            } catch (Exception e) {
//                throw new RuntimeException(e);
//            }
//        }
//        return hotSearch;
//    }

    @Scheduled(cron = "0 0/30 8-23 * * ?")
    public String wbHotSearch() throws UnsupportedEncodingException {
        StringBuilder top10Message = new StringBuilder();
        StringBuilder allMessage = new StringBuilder();
        String jsonResult = HttpUtil.createGet("https://weibo.com/ajax/statuses/hot_band").execute().charset("utf-8").body();
        JSONObject jsonObject = JSON.parseObject(jsonResult);
        Integer code = jsonObject.getInteger("http_code");
        if (code == null || code != 200) {
            return jsonResult;
        }
        int j = 1;
        JSONArray jsonArray = jsonObject.getJSONObject("data").getJSONArray("band_list");
        for (int i = 0; i < jsonArray.size(); i++) {
            JSONObject data = jsonArray.getJSONObject(i);
            String title = data.getString("word");
            String icon = data.getString("icon_desc");
            String raw_hot = data.getString("raw_hot");
            if (StringUtils.isBlank(raw_hot) || "null".equals(raw_hot)) {
                raw_hot = "-";
            }
            String searchUrl = "https://s.weibo.com/weibo?q=%23" + URLEncoder.encode(title, "utf-8") + "%23";
            if (icon == null) {
                icon = "-";
            }
            //top 10热搜
            if (i < 10) {
                top10Message.append(j).append(".").append(title).append(" ").append("[").append(icon).append("]").append("\n");
            }
            allMessage.append(j).append(".").append(title).append(" ").append("(").append(raw_hot).append(")").append("[查看](").append(searchUrl).append(")").append("\n");
            j++;
        }
        Date date = new Date();
        SimpleDateFormat df = new SimpleDateFormat("HH");
        SimpleDateFormat md = new SimpleDateFormat("MMdd");
        String str = df.format(date);
        String mmddStr = md.format(date);
        String historyToday = "### [历史上的今天(点我查看)](https://api.comm.miui.com/calendar-history-today/index.html?date=" + mmddStr + ")";
        Map<String, Object> param = new HashMap<>();
        String head = "---";
        param.put("key", "e8e8d2efda364a79b3797da2525c5f5e");
        param.put("head", "实时推送微博热点");
        int time = Integer.parseInt(str);
        //12点才推送的图片早报
        if (time <= 12) {
            String pictureUrl = HttpUtil.createGet("http://dwz.2xb.cn/zaob").execute().charset("utf-8").body();
            JSONObject pictureJson = JSON.parseObject(pictureUrl);
            String purl = pictureJson.getString("imageUrl");
            String msg1 = "### [每天60秒读懂世界(点我查看)](" + purl + ")";
            param.put("body", top10Message + "\n" + head + "\n" + msg1 + "\n" + historyToday + "\n" + allMessage);
        } else {
            param.put("body", top10Message + "\n" + head + "\n" + historyToday + "\n" + allMessage);
        }
        String url = "http://push.ijingniu.cn/send";
        String result = HttpUtil.post(url, param);
        log.info(result);

        return result;
    }

    // 微信即时达
    //    @GetMapping("/test")
    @Scheduled(cron = "0 0/30 7-23 * * ?")
    public String orderS() {
        Map<String, Object> param = new HashMap<>();
        param.put("key", "e8e8d2efda364a79b3797da2525c5f5e");
        param.put("head", "厦门天气");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(simpleDateFormat.format(new Date()));
        String Weather = "";
        try {
            URL url = new URL("http://t.weather.itboy.net/api/weather/city/101230201");
            InputStreamReader isReader = new InputStreamReader(url.openStream(), "UTF-8");//“UTF- 8”万国码，可以显示中文，这是为了防止乱码
            BufferedReader br = new BufferedReader(isReader);//采用缓冲式读入
            String str;
            String head = "---";
            while ((str = br.readLine()) != null) {
                String regex = "\\p{Punct}+";
                String digit[] = str.split(regex);
                Weather =
//                        "\n" + "城市:" + digit[22] + digit[18] +
//                                "" + "时间:" + digit[49] + "年" + digit[50] + "月" + digit[51] + "日" + digit[53] +
                        "" + "温度:" + digit[47] + "~" + digit[45] +
                                "\n" + "天气:" + digit[67] + " " + digit[63] + digit[65];
//                        + "\n" + digit[69];
                System.out.println(Weather);
            }
            br.close();//网上资源使用结束后，数据流及时关闭
            isReader.close();
        } catch (Exception exp) {
            System.out.println(exp);
            exp.printStackTrace();
        }
        param.put("body", Weather);
//        param.put("body","天气");
        String url = "http://push.ijingniu.cn/send";
        String result = HttpUtil.post(url, param);
        log.info(result);
        return result;
    }


    @Scheduled(cron = "0 55 10 * * ?")
    public String xiameWeather() throws UnsupportedEncodingException {
        Map<String, Object> param = new HashMap<>();
        param.put("key", "e8e8d2efda364a79b3797da2525c5f5e");
        param.put("head", "点餐啦");
        String url = "http://push.ijingniu.cn/send";
        String result = HttpUtil.post(url, param);
        log.info(result);
        return result;
    }
}