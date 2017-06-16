package com.dlfc.services.feedback.config;

import com.housecenter.dlfc.commons.bases.convertor.base.IConvertor;
import com.housecenter.dlfc.commons.bases.convertor.base.impl.JSONConvertor;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by walden on 17-6-16.
 */
@Configuration
public class ConvertorConfig {

    @Bean
    public IConvertor convertor(){
        IConvertor convertor = new JSONConvertor();
        return convertor;
    }
}
