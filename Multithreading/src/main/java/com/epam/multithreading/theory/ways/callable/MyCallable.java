package com.epam.multithreading.theory.ways.callable;

import java.util.concurrent.Callable;

public class MyCallable implements Callable<String> {
    private String threadName;

    public MyCallable(String threadName) {
        this.threadName = threadName;
    }

    @Override
    public String call() throws Exception {
        for (int i = 0; i < 25; i++) {
            System.out.println("Thread name:" + threadName + " incremented count: " + i);
        }
        return threadName + " is completed";
    }
}
