package com.epam.multithreading.theory.interrupts.interrupt;

public class DemoInterrupts {
    public static void main(String[] args) {
        MyThread myThread1 = new MyThread("myThread1");

        myThread1.start();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        myThread1.interrupt();
    }
}
