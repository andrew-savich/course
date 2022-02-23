package com.epam.annotations.practice.task1;

public class MyClass {

    @Greeting
    public void firstMethod() {
        System.out.println("The first method");
    }

    @Greeting(value = "Hello from the second method")
    public void secondMethod() {
        System.out.println("The second method");
    }
}
