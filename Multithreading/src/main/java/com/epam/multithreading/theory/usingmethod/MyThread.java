package com.epam.multithreading.theory.usingmethod;

public class MyThread extends Thread {
    private Service service;

    public MyThread(Service service, String name) {
        super(name);
        this.service = service;
    }

    public void run() {
        for (int i = 0; i < 100_000; i++) {
            service.simpleMethod(Thread.currentThread().getName());
            Service.staticMethod(Thread.currentThread().getName());
        }
    }
}
