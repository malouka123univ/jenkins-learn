package com.example;

public class App {
    static final String GREETING = "Hello from Jenkins CI/CD Pipeline!";

    public static void main(String[] args) {
        System.out.println(greeting());
    }

    static String greeting() {
        return GREETING;
    }
}
