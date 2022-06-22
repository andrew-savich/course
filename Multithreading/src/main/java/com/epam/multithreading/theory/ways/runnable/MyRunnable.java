package com.epam.multithreading.theory.ways.runnable;

public class MyRunnable implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 25; i++) {
            System.out.println("Thread name:" + Thread.currentThread().getName() + " incremented count: " + i);
        }
    }
}
