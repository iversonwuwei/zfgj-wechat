package com.dlfc.services.house;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@SpringCloudApplication
@EnableFeignClients
public class HouseApplication {

    public static void main(String[] args){
        SpringApplication.run(HouseApplication.class, args);
    }
}
