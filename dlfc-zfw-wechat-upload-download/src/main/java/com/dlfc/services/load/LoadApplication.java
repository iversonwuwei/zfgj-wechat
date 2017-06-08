package com.dlfc.services.load;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@SpringCloudApplication
@EnableFeignClients
public class LoadApplication {

    public static void main(String[] args){
        SpringApplication.run(LoadApplication.class, args);
    }
}
