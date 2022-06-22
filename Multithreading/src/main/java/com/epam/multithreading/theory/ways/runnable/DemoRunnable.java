package com.epam.multithreading.theory.ways.runnable;

public class DemoRunnable {
    public static void main(String[] args) {
        MyRunnable myRunnable1 = new MyRunnable();
        MyRunnable myRunnable2 = new MyRunnable();
        MyRunnable myRunnable3 = new MyRunnable();

        Thread thread1 = new Thread(myRunnable1);
        Thread thread2 = new Thread(myRunnable2);
        Thread thread3 = new Thread(myRunnable3);

        thread1.setName("1st Runnable thread");
        thread2.setName("2nd Runnable thread");
        thread3.setName("3rd Runnable thread");

        thread1.start();
        thread2.start();
        thread3.start();
    }
}
