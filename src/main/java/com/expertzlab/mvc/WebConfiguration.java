package com.expertzlab.mvc;

import org.apache.catalina.filters.RemoteIpFilter;
import org.springframework.context.annotation.Configuration;

/**
 * Created by gireeshbabu on 30/12/16.
 */
//@Configuration
public class WebConfiguration {

    public RemoteIpFilter remoteIpFilter(){
        return new RemoteIpFilter();
    }
}
