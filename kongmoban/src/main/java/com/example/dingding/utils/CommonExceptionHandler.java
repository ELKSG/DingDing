package com.example.dingding.utils;

import com.example.dingding.entity.CodeMsg;
import com.example.dingding.entity.CommonException;
import com.example.dingding.entity.Result;
import com.taobao.api.ApiException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
@Component
@Slf4j
public class CommonExceptionHandler {

    @Autowired
    private GlobalUtils globalUtils;

    @ExceptionHandler
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public Result handle(Exception exception) throws ApiException {

        if (exception instanceof CommonException) {
            log.error(exception.getMessage(), exception);
            CommonException e = (CommonException) exception;
            log.error("捕获到异常,异常代码为{},异常信息为{}", e.getErrCode(), e.getErrMsg());
            //发送异常信息到钉钉机器人
            globalUtils.globalMsg(exception);
            return Result.error(new CodeMsg(e.getErrCode(), e.getErrMsg()));

        } else if (exception instanceof HttpMessageNotReadableException) {
            log.error("前台传入JSON格式错误");
            //发送异常信息到钉钉机器人
            globalUtils.globalMsg(exception);
            return Result.error(CodeMsg.JSON_ERR);

        } else {
            //发送异常信息到钉钉机器人
            globalUtils.globalMsg(exception);
            log.error("捕获到异常错误");
            return Result.error(CodeMsg.FILES);
        }

    }
}
