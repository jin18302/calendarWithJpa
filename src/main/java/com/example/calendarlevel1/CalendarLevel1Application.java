package com.example.calendarlevel1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;


@SpringBootApplication
@EnableJpaAuditing
public class CalendarLevel1Application {

    public static void main(String[] args) {
        SpringApplication.run(CalendarLevel1Application.class, args);
    }

}
