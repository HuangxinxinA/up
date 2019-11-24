package com.ffcs.up.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;

/**
 * @author hxx
 */
public class HttpUtil {
    //带token的请求
    public static String post(String requestUrl, String accessToken, String params) throws Exception {
        String generalUrl = requestUrl + "?token=" + accessToken;
        URL url = new URL(generalUrl);
        // 打开和URL之间的连接
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("POST");
        // 设置通用的请求属性
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setRequestProperty("Connection", "Keep-Alive");
        connection.setUseCaches(false);
        connection.setDoOutput(true);
        connection.setDoInput(true);

        // 得到请求的输出流对象
        DataOutputStream out = new DataOutputStream(connection.getOutputStream());
        out.writeBytes(params);
        out.flush();
        out.close();

        // 建立实际的连接
        connection.connect();
        // 获取所需响应头字段
        String info = connection.getHeaderField("sendStatus");
        System.out.println("Token校验的响应结果为:" + info);
        // 定义 BufferedReader输入流来读取URL的响应
        BufferedReader in = null;
        if (requestUrl.contains("nlp")){
            in = new BufferedReader(new InputStreamReader(connection.getInputStream(), "GBK"));
        } else{
            in = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));
        }
        String result = "";
        String getLine;
        while ((getLine = in.readLine()) != null) {
            result += getLine;
        }
        in.close();
        System.out.println("发送数据的响应结果为:" + result);
        return result;
    }

    //获取token的请求
    public static String getToken(String requestUrl, String mac,String diskId) throws Exception {
        String mix = mac+diskId;
        String encryptByAes = EncryptUtils.encryptByAes(mix);
        String generalUrl = requestUrl + "?basic=" + encryptByAes;
        URL url = new URL(generalUrl);
        // 打开和URL之间的连接
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("POST");
        // 设置通用的请求属性
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setRequestProperty("Connection", "Keep-Alive");
        connection.setUseCaches(false);
        connection.setDoOutput(true);
        connection.setDoInput(true);

        // 建立实际的连接
        connection.connect();
        // 定义 BufferedReader输入流来读取URL的响应
        BufferedReader in = null;
        if (requestUrl.contains("nlp")){
            in = new BufferedReader(new InputStreamReader(connection.getInputStream(), "GBK"));
        }
        else{
            in = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));
        }
        String result = "";
        String getLine;
        while ((getLine = in.readLine()) != null) {
            result += getLine;
        }
        in.close();
        System.out.println("获取Token的响应结果为:" + result);
        JSONObject jsonObject = JSON.parseObject(result);
        Object o = jsonObject.get("token");
        if (o!=null){
            return o.toString();
        }
        return null;
    }
}
