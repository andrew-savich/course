package com.epam.multithreading.theory.ways.thread;

public class DemoThread {
    public static void main(String[] args) {
        MyThread myThread1 = new MyThread();
        MyThread myThread2 = new MyThread();
        MyThread myThread3 = new MyThread();

        myThread1.setName("1st thread");
        myThread2.setName("2nd thread");
        myThread3.setName("3rd thread");

        myThread1.start();
        myThread2.start();
        myThread3.start();
    }
}
