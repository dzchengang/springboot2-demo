package com.sdstc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class K8sStart extends SpringBootServletInitializer{
    public static void main(String[] args) {
        SpringApplication.run(K8sStart.class, args);
    }
   
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
    	
      return builder.sources(K8sStart.class);
    }
}
