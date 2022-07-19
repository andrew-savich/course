package com.epam.multithreading.theory.stop;

public class DemoStop {
    public static void main(String[] args) {
        Store store = new Store();
        Producer producer = new Producer(store);
        Consumer consumer = new Consumer(store);
        Consumer consumer2 = new Consumer(store);

        new Thread(producer).start();
        new Thread(consumer).start();
        new Thread(consumer2).start();
    }
}
