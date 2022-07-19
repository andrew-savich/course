package com.epam.multithreading.theory.join;

public class DemoJoin {
    public static void main(String[] args) throws InterruptedException {
        MyThread myThread1 = new MyThread("myThread1");
        MyThread myThread2 = new MyThread("myThread2");
        MyThread myThread3 = new MyThread("myThread3");

        myThread1.start();
        myThread1.join();

        myThread2.start();
        myThread2.join();

        myThread3.start();
    }
}
