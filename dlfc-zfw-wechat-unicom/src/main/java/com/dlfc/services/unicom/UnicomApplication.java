package com.dlfc.services.unicom;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@SpringCloudApplication
@EnableFeignClients
public class UnicomApplication {

    public static void main(String[] args){
        SpringApplication.run(UnicomApplication.class, args);
    }
}
