package com.example.dingding.entity;


public class CommonException extends RuntimeException{

    private Integer errCode;

    private String errMsg;

    public Integer getErrCode() {
        return errCode;
    }

    public void setErrCode(Integer errCode) {
        this.errCode = errCode;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    public CommonException(Integer errCode, String errMsg) {
        this.errCode = errCode;
        this.errMsg = errMsg;
    }

    public CommonException(String errMsg, Throwable e) {
        super(errMsg);
        this.errMsg = errMsg;
    }
}
