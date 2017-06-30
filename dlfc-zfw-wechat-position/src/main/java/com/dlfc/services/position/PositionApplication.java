package com.dlfc.services.position;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

/**
 * Created by walden on 17-6-30.
 */
@SpringCloudApplication
@EnableFeignClients(basePackages = {"com.dlfc.services.position", "com.housecenter.dlfc.framework.ca.api"})
public class PositionApplication {

    public static void main(String[] args){
        SpringApplication.run(PositionApplication.class, args);
    }
}
