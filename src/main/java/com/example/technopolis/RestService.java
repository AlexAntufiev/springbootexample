package com.example.technopolis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

//@EnableAutoConfiguration
@SpringBootApplication
public class RestService extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(RestService.class, args);
    }

//    @Override
//    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
//        return builder.sources(RestService.class);
//    }
}

