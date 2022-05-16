package com.epam.multithreading.theory.daemon;

public class DaemonThreadExample extends Thread {

    public void run() {
        System.out.println("Thread running");
    }

    public static void main(String[] args) {
        DaemonThreadExample firstThread = new DaemonThreadExample();
        DaemonThreadExample secondThread = new DaemonThreadExample();

        firstThread.setDaemon(true);

        firstThread.start();
        secondThread.start();

        System.out.println(firstThread.isDaemon());
        System.out.println(secondThread.isDaemon());
    }
}
