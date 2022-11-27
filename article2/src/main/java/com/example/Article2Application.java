package com.example;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.web.bind.annotation.CrossOrigin;
@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
@MapperScan("com.example.entity")
@CrossOrigin
public class Article2Application {

    public static void main(String[] args) {
        SpringApplication.run(Article2Application.class, args);
    }

}
