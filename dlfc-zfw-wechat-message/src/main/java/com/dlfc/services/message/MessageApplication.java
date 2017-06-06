package com.dlfc.services.message;


import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@SpringCloudApplication
@EnableFeignClients
public class MessageApplication {

    public static void main(String[] args){
        SpringApplication.run(MessageApplication.class, args);
    }
}
