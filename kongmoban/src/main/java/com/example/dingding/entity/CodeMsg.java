package com.example.dingding.entity;

public class CodeMsg {

    private int code;
    private String msg;

    public CodeMsg(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public CodeMsg() {
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public static CodeMsg SUCCESS = new CodeMsg(200, "success");

    public static CodeMsg FILES = new CodeMsg(300, "未知错误");
    public static CodeMsg JSON_ERR = new CodeMsg(300, "JSON格式错误");

}
