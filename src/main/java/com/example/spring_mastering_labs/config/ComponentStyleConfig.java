package com.example.spring_mastering_labs.config;

import com.example.spring_mastering_labs.domain.MyBeanFromComponent;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class ComponentStyleConfig {

    @Bean
    public MyBeanFromComponent myBean() {
        return new MyBeanFromComponent();
    }

    @Bean
    public MyBeanFromComponent anotherBean() {
        return myBean(); // ❌ no proxy
    }

}
