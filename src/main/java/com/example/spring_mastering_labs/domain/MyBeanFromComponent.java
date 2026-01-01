package com.example.spring_mastering_labs.domain;

public class MyBeanFromComponent {
    public MyBeanFromComponent() {
        System.out.println("MyBean from { @Component } created: " + this);
    }
}
