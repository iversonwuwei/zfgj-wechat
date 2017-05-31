package com.walden.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;

@SpringCloudApplication
public class DrinkApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(DrinkApplication.class);

    public static void main(String[] args) throws Exception {
        SpringApplication.run(DrinkApplication.class);
        LOGGER.info(
                "======================================= Drink Start Successfully =======================================");
    }

}
