package com.epam.multithreading.theory.priority;

public class DemoPriority {
    public static void main(String[] args) {
        Thread thread1 = new Thread("thread1") {
            @Override
            public void run() {
                threadWork(this.getName());
            }
        };

        Thread thread2 = new Thread("thread2") {
            @Override
            public void run() {
                threadWork(this.getName());
            }
        };

        thread1.setPriority(Thread.MIN_PRIORITY);
        thread2.setPriority(Thread.MAX_PRIORITY);

        thread1.start();
        thread2.start();
    }

    private static void threadWork(String threadName) {
        for (int i = 0; i < 15; i++) {
            System.out.println("Now working thread: " + threadName + " with increment: " + i);
        }
    }
}
