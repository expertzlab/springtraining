package com.expertzlab.mvc;

import org.apache.catalina.filters.RemoteIpFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.ByteArrayHttpMessageConverter;

/**
 * Created by gireeshbabu on 30/12/16.
 */
@Configuration
public class WebConfiguration {

    @Bean
    public RemoteIpFilter remoteIpFilter(){
        return new RemoteIpFilter();
    }


    @Bean
    public ByteArrayHttpMessageConverter byteArrayHttpMessageConverter(){
        return new ByteArrayHttpMessageConverter();
    }

}
