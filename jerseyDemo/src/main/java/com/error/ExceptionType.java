package com.error;

public enum ExceptionType {
    NO_LOGIN(0,"未登录"),OVERTIME(1,"认证过期"),NO_PERM(3,"未拥有权限");

    private int code;
    private String msg;

    ExceptionType(int code, String msg) {
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
}
