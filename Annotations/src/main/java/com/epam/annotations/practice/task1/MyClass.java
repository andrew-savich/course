package com.epam.annotations.practice.task1;

public class MyClass {

    @Greeting
    void firstMethod() {
        System.out.println("The first method");
    }

    @Greeting(value = "Hello from the second method")
    void secondMethod() {
        System.out.println("The second method");
    }
}
