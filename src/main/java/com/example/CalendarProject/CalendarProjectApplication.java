package com.example.CalendarProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;


@SpringBootApplication
@EnableJpaAuditing
public class CalendarProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(CalendarProjectApplication.class, args);
    }

}
