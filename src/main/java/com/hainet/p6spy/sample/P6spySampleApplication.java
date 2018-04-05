package com.hainet.p6spy.sample;

import com.hainet.p6spy.sample.domain.dao.PersonDao;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class P6spySampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(P6spySampleApplication.class, args);
    }

    @Bean
    public CommandLineRunner runner(final PersonDao dao) {
        return args -> dao.findById(1);
    }
}
