package com.dlfc.zfw.wechat.registry;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@SpringCloudApplication
@EnableFeignClients
public class RegistryApplication {

    public static void main(String[] args){
        SpringApplication.run(RegistryApplication.class, args);
    }
}
