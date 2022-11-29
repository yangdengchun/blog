package com.example.resmanger;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
@MapperScan("com.example.resmanger.mapper")
public class ResmangerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ResmangerApplication.class, args);
    }


}
