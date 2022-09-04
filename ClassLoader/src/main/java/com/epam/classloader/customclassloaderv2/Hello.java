package com.epam.classloader.customclassloaderv2;

public class Hello {
    public void m1(String text, int c) {
        for (int i = 0; i < c; i++) {
            System.out.println(text + " Hi" + i);
        }
    }

    public static void m2(String text) {
        System.out.println(text + " from static method");
    }

}
