package com.ffcs.up.to;

import java.io.Serializable;
import java.util.Date;

//校验状态
public class TokenStatus implements Serializable {
    private String result;
    private String info;
    private String token;
    private Date date;

    public static final String RESULT_SUCCESS = "success";
    public static final String RESULT_FAIL = "fail";
    public static final String INFO_TOKEN_CHECK_FAIL = "身份校验失败";
    public static final String INFO_TOKEN_CREATE_FAIL = "生成Token失败";
    public static final String INFO_TOKEN_CREATE_SUCCESS = "生成Token成功";

    @Override
    public String toString() {
        return "TokenStatus{" +
                "result='" + result + '\'' +
                ", info='" + info + '\'' +
                ", token='" + token + '\'' +
                ", date=" + date +
                '}';
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getResult() {
        return result;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

}
