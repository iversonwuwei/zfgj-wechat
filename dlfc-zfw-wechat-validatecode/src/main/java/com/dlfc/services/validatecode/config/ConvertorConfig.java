package com.dlfc.services.validatecode.config;

import com.housecenter.dlfc.commons.bases.convertor.base.IConvertor;
import com.housecenter.dlfc.commons.bases.convertor.base.impl.JSONConvertor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConvertorConfig {

    @Bean
    public IConvertor getConvertor() {
        IConvertor convertor = new JSONConvertor();

        return convertor;
    }

}
