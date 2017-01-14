package com.expertzlab.mvc;

import com.expertzlab.readbook.BookRepo;
import com.expertzlab.util.BookFormatter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.converter.ByteArrayHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

import java.util.List;

@Configuration
public class MvcConfig extends WebMvcConfigurerAdapter {

    @Autowired
    private BookRepo bookRepo;

    private static Logger logger = LoggerFactory.getLogger(MvcConfig.class);
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {

        registry.addViewController("/home").setViewName("home");
        registry.addViewController("/").setViewName("home");
        registry.addViewController("/hello").setViewName("hello");
        registry.addViewController("/login").setViewName("login");
    }

     /*
    @Bean
    public LocaleChangeInterceptor getLocaleChangeIntercetpor(){
        return new LocaleChangeInterceptor();
    }

   @Override
    public void addInterceptors(InterceptorRegistry registry){

       logger.debug("adding interceptor");
        registry.addInterceptor(getLocaleChangeIntercetpor());
    }


   @Override
   public void configureMessageConverters(List<HttpMessageConverter<?>> converters){
       converters.add(new ByteArrayHttpMessageConverter());
   }


    public void extendMessageConverters(List<HttpMessageConverter<?>> converters){
        converters.clear();
        converters.add(new ByteArrayHttpMessageConverter());
    }
*/

    @Override
    public void addFormatters(FormatterRegistry registry){
        registry.addFormatter(new BookFormatter(bookRepo));
    }

}