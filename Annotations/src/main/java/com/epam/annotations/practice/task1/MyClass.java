package com.epam.annotations.practice.task1;

public class MyClass {

    @Greeting
    void firstMethod() {
    }

    @Greeting(value = "Hello the second method")
    void secondMethod() {
    }
}
