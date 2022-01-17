package com.bs.codetest.api;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableCaching
@ComponentScan(basePackages = {"com.bs.codetest.api", "org.openapitools.configuration"})
public class CodetestApiInvoker {

   /* @Override
    public void run(String... arg0) throws Exception {
        if (arg0.length > 0 && arg0[0].equals("exitcode")) {
            throw new ExitException();
        }
    }*/

    public static void main(String[] args) throws Exception {
        new SpringApplication(CodetestApiInvoker.class).run(args);
    }

    /*static class ExitException extends RuntimeException implements ExitCodeGenerator {

        private static final long serialVersionUID = 1L;

        @Override
        public int getExitCode() {
            return 10;
        }

    }*/

    /*@Bean
    public Module jsonNullableModule() {
        return new JsonNullableModule();
    }*/

}
