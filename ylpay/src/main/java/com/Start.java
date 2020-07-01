package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import com.unionpay.acp.sdk.SDKConfig;

@SpringBootApplication
public class Start extends SpringBootServletInitializer{
    public static void main(String[] args) {
    	SDKConfig.getConfig().loadPropertiesFromSrc();
        SpringApplication.run(Start.class, args);
    }
    
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
      return builder.sources(Start.class);
    }
}
