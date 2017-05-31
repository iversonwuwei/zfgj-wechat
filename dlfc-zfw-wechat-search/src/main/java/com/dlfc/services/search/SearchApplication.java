package com.dlfc.services.search;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringCloudApplication
@ComponentScan(basePackages = "com.dlfc.services.search")
public class SearchApplication {

    public static void main(String[] args){
        SpringApplication.run(SearchApplication.class, args);
    }
}
