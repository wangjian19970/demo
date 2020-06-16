package com.example.demo.enums;

public enum TestEnum {
    IS_SUCCESS(1, "成功"),
    IS_FALL(0, "失败");

    private int code;
    private String msg;

    TestEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
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

    @Override
    public String toString() {
        return "TestEnum{" + "code=" + code + ",msg=" + msg + '\'' + '}';
    }
}
