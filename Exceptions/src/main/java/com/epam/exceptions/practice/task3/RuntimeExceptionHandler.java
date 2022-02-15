package com.epam.exceptions.practice.task3;

public class RuntimeExceptionHandler implements Thread.UncaughtExceptionHandler{
    @Override
    public void uncaughtException(Thread t, Throwable e) {
        System.out.println("Was caught exception in the thread: " + t.getName());
        System.out.println("Cause: " + e.getCause() + " with message: " + e.getMessage());
        System.out.println("e.getStackTrace(): " + e.getStackTrace());

        e.printStackTrace();
    }
}
