package com.dlfc.services.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@SpringCloudApplication
@EnableFeignClients
public class AuthApplication {

    public static void main(String[] args){
        SpringApplication.run(AuthApplication.class, args);
    }
}
