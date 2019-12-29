package com.ihrm.system;


import com.ihrm.commom.utils.IdWorker;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;

//1.配置springboot的包扫描  扫描当前微服务模块
@SpringBootApplication(scanBasePackages = "com.ihrm")

//2.配置jpa注解的扫描
@EntityScan("com.ihrm.domain.system")
public class SystemApplication {
    public static void main(String[] args) {
        SpringApplication.run(SystemApplication.class,args);
    }

    @Bean
    public IdWorker idWorker(){
        return new IdWorker();
    }
}
