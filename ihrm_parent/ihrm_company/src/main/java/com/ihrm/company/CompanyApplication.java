package com.ihrm.company;

import com.ihrm.commom.utils.IdWorker;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;


//1.配置springboot的包扫描
@SpringBootApplication(scanBasePackages = "com.ihrm.company")

//2.配置jpa注解的扫描
@EntityScan("com.ihrm.domain.company")
public class CompanyApplication {
    public static void main(String[] args) {
        SpringApplication.run(CompanyApplication.class,args);
    }

    @Bean
    public IdWorker idWorker(){
        return new IdWorker();
    }
}
