package com.dlfc.services.validate;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@SpringCloudApplication
@EnableFeignClients
public class ValidateApplication {

    public static void main(String[] args){
        SpringApplication.run(ValidateApplication.class, args);
    }
}
