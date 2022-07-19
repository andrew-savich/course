package com.epam.multithreading.theory.usingmethod;

public class Demo {
    public static void main(String[] args) throws InterruptedException {
        Service commonService = new Service();
        MyThread myThread1 = new MyThread(commonService, "Thread1");
        MyThread myThread2 = new MyThread(commonService, "Thread2");

        myThread1.start();
        myThread2.start();

        myThread1.join();
        myThread2.join();

        commonService.showCounts();
    }
}
