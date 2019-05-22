package com.example.wangchang.testpalette.bean;

public class RootBean {
    boolean ret;
    int code;
    DataBean data;
    String message;
    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isRet() {
        return ret;
    }

    public void setRet(boolean ret) {
        this.ret = ret;
    }

    public RootBean(boolean ret, int code, DataBean data, String message) {
        this.ret = ret;
        this.code = code;
        this.data = data;
        this.message = message;
    }

    public RootBean(boolean ret, int code, String message) {
        this.ret = ret;
        this.code = code;
        this.message = message;
    }
}
