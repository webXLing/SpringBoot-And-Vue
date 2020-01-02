package com.xxl.springbootquick.config;


import com.xxl.springbootquick.service.Tservice;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Configuration 告诉spring 这是个配置文件
 * Bean 将该方法的返回值 放入 容器
 */
@Configuration
public class Tconfig {


    @Bean
    public Object testObj(){
        return new Tservice();
    }
}
