package com.dlfc.services.collect;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@SpringCloudApplication
@EnableFeignClients
public class CollectApplication {

    public static void main(String[] args){
        SpringApplication.run(CollectApplication.class, args);
    }
}
