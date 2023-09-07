package com.andrewsavich;

public class InstanceOfExample {
    public static void main(String[] args) {
        //Old versionsL:
        Object o = "Hello, World!";
        if (o instanceof String) {
            String s = (String) o;
            System.out.println(s.length());
        }

        //Since Java 17:
        Object o2 = "Hello, World!";
        if (o2 instanceof String s) {
            System.out.println(s.length());
        }

        //One more case
        Object o3 = "Hello, World!";
        if (o3 instanceof String s && !s.isBlank()) {
            System.out.println(s.toLowerCase());
        }
    }
}
