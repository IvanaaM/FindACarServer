package com.ftn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class FindACarApplication {

    public static void main(String[] args) {
        SpringApplication.run(FindACarApplication.class, args);

    }

}
