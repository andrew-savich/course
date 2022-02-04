package com.epam.theory.classclass;

class Car implements Vehicle{
    private String name;
    private Fuel fuel;
    public boolean engineStarted;

    public Car(String name, Fuel fuel) {
        this.name = name;
        this.fuel = fuel;
    }

    @Override
    public void move() {
        System.out.println("Car is moving");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Fuel getFuel() {
        return fuel;
    }

    public void setFuel(Fuel fuel) {
        this.fuel = fuel;
    }
}
