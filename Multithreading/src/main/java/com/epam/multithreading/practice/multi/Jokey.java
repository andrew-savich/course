package com.epam.multithreading.practice.multi;

public class Jokey {
    private String name;

    public Jokey(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int changeSpeed() {
        return (int) (Math.random() * (6 + 1)) - 2;
    }
}
