package com.dlfc.services.unicom.config;


import com.housecenter.dlfc.commons.bases.convertor.base.IConvertor;
import com.housecenter.dlfc.commons.bases.convertor.base.impl.JSONConvertor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConvertorConfig {

    @Bean
    public IConvertor convertor(){
        IConvertor convertor = new JSONConvertor();
        return convertor;
    }
}
