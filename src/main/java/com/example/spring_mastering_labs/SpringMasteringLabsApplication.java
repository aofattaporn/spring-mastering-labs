package com.example.spring_mastering_labs;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringMasteringLabsApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(SpringMasteringLabsApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Application started");
//        System.out.println("myBean: " + ctx.get("myBean"));
//        System.out.println("anotherBean: " + ctx.getBean("anotherBean"));
    }
}
