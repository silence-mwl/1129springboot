package com.zr;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@MapperScan("com.zr.dao") // 扫描接口包生成dao的代理对象
@EnableTransactionManagement //开启事务
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
