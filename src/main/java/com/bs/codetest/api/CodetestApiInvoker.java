package com.bs.codetest.api;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.retry.annotation.EnableRetry;

@SpringBootApplication
@EnableRetry
@EnableCaching
public class CodetestApiInvoker {


    public static void main(String[] args) throws Exception {
        new SpringApplication(CodetestApiInvoker.class).run(args);
    }

    /*@Bean
    public RetryTemplate retryTemplate()
    {
        RetryTemplate retryTemplate = new RetryTemplate();

        FixedBackOffPolicy backOffPolicy = new FixedBackOffPolicy();
        backOffPolicy.setBackOffPeriod(100);

        SimpleRetryPolicy simpleRetryPolicy = new SimpleRetryPolicy();
        simpleRetryPolicy.setMaxAttempts(2);

        retryTemplate.setRetryPolicy(simpleRetryPolicy);
        retryTemplate.setBackOffPolicy(backOffPolicy);
        return retryTemplate;
    }*/

}
