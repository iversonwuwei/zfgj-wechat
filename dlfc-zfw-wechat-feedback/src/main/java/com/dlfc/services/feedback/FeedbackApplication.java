package com.dlfc.services.feedback;


import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@SpringCloudApplication
@EnableFeignClients
public class FeedbackApplication {

    public static void main(String[] args){
        SpringApplication.run(FeedbackApplication.class, args);
    }
}
