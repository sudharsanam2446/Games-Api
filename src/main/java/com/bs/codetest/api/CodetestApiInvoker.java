package com.bs.codetest.api;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableCaching
@ComponentScan(basePackages = {"com.bs.codetest.api", "org.openapitools.configuration"})
public class CodetestApiInvoker {


    public static void main(String[] args) throws Exception {
        new SpringApplication(CodetestApiInvoker.class).run(args);
    }

}
