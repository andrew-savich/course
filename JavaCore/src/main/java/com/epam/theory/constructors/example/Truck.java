package com.epam.theory.constructors.example;

public class Truck extends Car{
    private int countWheals;

    public Truck(String name, int countWheals) {
        super(name);
        this.countWheals = countWheals;
    }
}
