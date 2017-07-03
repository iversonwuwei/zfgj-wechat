package com.dlfc.services.commons;


import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@SpringCloudApplication
@EnableDiscoveryClient
@EnableFeignClients
public class DlfcCommonsApplication {

    public static void main(String[] args) {
        SpringApplication.run(DlfcCommonsApplication.class, args);
    }
}
