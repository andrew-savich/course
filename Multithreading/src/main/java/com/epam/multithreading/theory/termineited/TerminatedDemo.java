package com.epam.multithreading.theory.termineited;

public class TerminatedDemo {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Executing thread");
            }
        });

        thread.start();
        thread.join();

        thread.start();
    }
}
