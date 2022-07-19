package com.epam.multithreading.theory.dedlock;

public class DeadlockDemo {
    public static void main(String[] args) {
        RecourseA recourseA = new RecourseA();
        RecourseB recourseB = new RecourseB();

        Thread thread1 = new Thread(() -> {
            recourseA.doFirst(recourseB);
        });

        Thread thread2 = new Thread(() -> {
            recourseB.doFirst(recourseA);
        });

        thread1.start();
        thread2.start();
    }

    public static class RecourseA {
        synchronized void doFirst(RecourseB recourseB) {
            System.out.println(Thread.currentThread().getName() + " entered into RecourseA.doFirst(RecourseB recourseB)");
            System.out.println(Thread.currentThread().getName() + " wants to enter recourseB.doSecond()");
            recourseB.doSecond();
        }

        synchronized void doSecond() {
            System.out.println(Thread.currentThread().getName() + " entered into RecourseA.doSecond()");
        }
    }

    public static class RecourseB {
        synchronized void doFirst(RecourseA recourseA) {
            System.out.println(Thread.currentThread().getName() + " entered into RecourseB.doFirst(RecourseA recourseA)");
            System.out.println(Thread.currentThread().getName() + " wants to enter recourseA.doSecond()");
            recourseA.doSecond();
        }

        synchronized void doSecond() {
            System.out.println(Thread.currentThread().getName() + " entered into RecourseB.doSecond()");
        }
    }
}
