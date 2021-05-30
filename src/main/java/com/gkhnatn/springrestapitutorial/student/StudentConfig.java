package com.gkhnatn.springrestapitutorial.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository) {
        return args -> {
            var alex = new Student(
                    1L,
                    "Alex De Souza",
                    "alex@trendyol.com",
                    LocalDate.of(1995, Month.MAY, 7)
            );

            var gkhatn = new Student(
                    2L,
                    "Gökhan Atan",
                    "gokhan.atan@trendyol.com",
                    LocalDate.of(1991, Month.MAY, 21)
            );

            repository.saveAll(List.of(alex,gkhatn));
        };
    }
}
