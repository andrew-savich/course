package com.epam.exceptions.practice.task3;

public class DemoTask3 {
    public static void main(String[] args) {
        Thread.setDefaultUncaughtExceptionHandler(new RuntimeExceptionHandler());

        System.out.println(1/0);
    }
}
