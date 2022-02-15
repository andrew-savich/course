package com.epam.exceptions.practice.task3;

//  - Use the interface Thread.UncaughtExceptionHandler
//  - Use the methods getCause, getMessage of the Throwable class
//  - Use the methods getStackTrace, printStackTrace of the Throwable class
public class DemoTask3 {
    public static void main(String[] args) {
        Thread.setDefaultUncaughtExceptionHandler(new RuntimeExceptionHandler());

        throw new RuntimeException();
    }
}
