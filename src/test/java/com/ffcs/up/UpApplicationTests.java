package com.ffcs.up;

import com.ffcs.up.util.HttpUtil;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UpApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    void send() throws Exception {
        String tokenUrl = "http://localhost:8080/token";
        String receiveUrl = "http://localhost:8080/service/receive";
        String mac = "0A-00-27-00-00-02";
        String diskId = "70667590";
        String data = "hello";
        boolean flag = true;
        String token = null;
        while (flag){
            token = HttpUtil.getToken(tokenUrl, mac, diskId);
            if (token!=null){
                flag = false;
            }
        }
        HttpUtil.post(receiveUrl, token, data);
    }

}
