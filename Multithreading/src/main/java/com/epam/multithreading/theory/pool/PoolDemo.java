package com.epam.multithreading.theory.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PoolDemo {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2); //2 активных потока
        for (int i = 0; i < 10; i++) {
            executorService.submit(new MyThread("thread" + i)); //создаем 10 потоков и сабмитаем в пул
        }
        executorService.shutdown();
    }

    public static class MyThread extends Thread {
        String name;
        public MyThread(String name) {
            this.name = name;
        }
        public void run() {
            System.out.println(Thread.currentThread().getName() + ": " + name);
        }
    }
}

