package com.dlfc.services.date;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@SpringCloudApplication
@EnableFeignClients(basePackages = {"com.dlfc.services.date", "com.housecenter.dlfc.framework.ca.api"})
public class DateApplication {

    public static void main(String[] args) {
        SpringApplication.run(DateApplication.class, args);
    }
}
