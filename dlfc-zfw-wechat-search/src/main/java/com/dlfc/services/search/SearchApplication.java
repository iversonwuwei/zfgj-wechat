package com.dlfc.services.search;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringCloudApplication
@EnableFeignClients(basePackages = {"com.dlfc.services.search","com.housecenter.dlfc.framework.ca.api"})
public class SearchApplication {

    public static void main(String[] args){
        SpringApplication.run(SearchApplication.class, args);
    }
}
