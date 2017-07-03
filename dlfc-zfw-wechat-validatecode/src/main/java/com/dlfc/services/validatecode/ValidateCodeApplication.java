package com.dlfc.services.validatecode;


import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@SpringCloudApplication
@EnableFeignClients
public class ValidateCodeApplication {

    public static void main(String[] args) {
        SpringApplication.run(ValidateCodeApplication.class, args);
    }
}