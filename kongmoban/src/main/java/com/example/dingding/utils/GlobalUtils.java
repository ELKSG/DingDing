package com.example.dingding.utils;

import com.example.dingding.controller.DingDing;
import com.taobao.api.ApiException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.PrintWriter;
import java.io.StringWriter;

@Component
public class GlobalUtils {

    @Autowired
    private DingDing dingDing;

    public void globalMsg(Exception exception) throws ApiException {
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw, true);
        exception.printStackTrace(pw);
        String stackTraceString = sw.getBuffer().toString();
        dingDing.sendMsg(stackTraceString);
    }
}
