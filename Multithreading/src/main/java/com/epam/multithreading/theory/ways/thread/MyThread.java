package com.epam.multithreading.theory.ways.thread;

public class MyThread extends Thread {
    public void run() {
        for (int i = 0; i < 25; i++) {
            System.out.println("Thread name:" + Thread.currentThread().getName() + " incremented count: " + i);
        }
    }
}
