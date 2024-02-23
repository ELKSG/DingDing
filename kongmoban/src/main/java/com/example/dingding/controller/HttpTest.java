package com.example.dingding.controller;

import java.net.*;
import java.io.*;

public class HttpTest {

    private static HttpURLConnection con;

    public static void main(String[] args) throws Exception {

        URL url = new URL("https://weibo.com/ajax/statuses/hot_band");
        con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");

        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer content = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }
        in.close();
        con.disconnect();

        System.out.println(content.toString());
    }
}