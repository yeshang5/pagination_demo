package com.baihao;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages="com.baihao.modules")
public class PaginationDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(PaginationDemoApplication.class, args);
    }

}
