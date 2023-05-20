package com.yqcui.yqweb;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.yqcui.yqweb.mapper")
public class YqWebApplication {
    public static void main(String[] args) {
        SpringApplication.run(YqWebApplication.class, args);
    }
}
