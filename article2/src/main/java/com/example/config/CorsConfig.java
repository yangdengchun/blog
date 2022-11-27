package com.example.config;

/**
 * @author ydc
 * @create 2022-09-21 18:14
 */

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 解决跨域问题
 */
@Configuration
public class CorsConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")//设置允许跨域的路径
                .allowedOrigins("*")//设置允许跨域请求的域名
                .allowedMethods("GET", "HEAD", "POST", "PUT", "DELETE", "OPTIONS")//设置允许的方法
                .allowCredentials(true)//是否允许证书 不再默认开启
                .maxAge(3600)//跨域允许时间
                .allowedHeaders("*");
    }
}
