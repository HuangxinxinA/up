package com.ffcs.up;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@MapperScan("com.ffcs.up.dao.auto")
public class UpApplication {

    public static void main(String[] args) {
        SpringApplication.run(UpApplication.class, args);
    }

}
