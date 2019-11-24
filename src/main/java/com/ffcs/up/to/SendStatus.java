package com.ffcs.up.to;

import java.io.Serializable;
import java.util.Date;

//发送状态
public class SendStatus implements Serializable {
    private String result;
    private String info;
    private Date date;

    public static final String RESULT_SUCCESS = "success";
    public static final String RESULT_FAIL = "fail";
    public static final String INFO_SEND_FAIL = "数据发送失败";
    public static final String INFO_SEND_SUCCESS = "数据发送成功";
    public static final String INFO_CHECK_FAIL = "Token校验失败";
    public static final String INFO_CHECK_SUCCESS = "Token校验成功";

    @Override
    public String toString() {
        return "SendStatus{" +
                "result='" + result + '\'' +
                ", info='" + info + '\'' +
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
