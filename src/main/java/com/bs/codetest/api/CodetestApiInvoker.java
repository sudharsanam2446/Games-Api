package com.bs.codetest.api;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class CodetestApiInvoker {


    public static void main(String[] args) throws Exception {
        new SpringApplication(CodetestApiInvoker.class).run(args);
    }

}
