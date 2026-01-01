package com.example.spring_mastering_labs.config;

import com.example.spring_mastering_labs.domain.MyBeanFromConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigStyleConfig {

    @Bean
    public MyBeanFromConfig myBeanFromConfig() {
        return new MyBeanFromConfig();
    }

    @Bean
    public MyBeanFromConfig anotherBean1() {
        return myBeanFromConfig(); // 🔥 critical
    }

}

