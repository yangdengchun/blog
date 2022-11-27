package com.example.config;

import com.example.interceptor.JwtInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author ydc
 * @create 2022-09-20 23:15
 */
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
    @Autowired
    private JwtInterceptor jwtInterceptor;


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(jwtInterceptor) //添加拦截器
                // .addPathPatterns("/**")  //拦截路径
                // .excludePathPatterns("/user/**"); //不拦截路径
                .addPathPatterns("")  //拦截路径
                .excludePathPatterns(""); //不拦截路径
    }
}
