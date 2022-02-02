package com.epam.practice.task2.divisions;

public abstract class MilitaryHeadquarters {
    public abstract String calculateLocation();

    public void report(){
        System.out.println("Calculating a location: " + calculateLocation());
    }

}
