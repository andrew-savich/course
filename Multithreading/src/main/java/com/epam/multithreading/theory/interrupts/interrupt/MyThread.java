package com.epam.multithreading.theory.interrupts.interrupt;

public class MyThread extends Thread {
    private int count = 0;
    private String name;

    public MyThread(String name) {
        this.name = name;
    }

    public void run() {
        try {
            while (!isInterrupted()) {
                System.out.println(name + " is executing " + ++count);
                Thread.sleep(1000);
            }
        } catch (InterruptedException exc) {
            System.out.println("InterruptedException caught in the " + name);
        }
    }
}
