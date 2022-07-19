package com.epam.multithreading.theory.usingmethod;

public class Service {
    private int simpleCount = 0;
    private static int staticCount = 0;

    public void simpleMethod(String threadName) {
        System.out.println("SIMPLE method from thread: " + threadName);
        simpleCount++;
    }

    public static void staticMethod(String threadName) {
        System.out.println("STATIC method" + threadName);
        staticCount++;
    }

    public void showCounts() {
        System.out.println("simpleCount:" + simpleCount);
        System.out.println("staticCount:" + staticCount);
    }
}
