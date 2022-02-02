package com.epam.practice.task2.divisions;

public class FlyingDivision extends MilitaryHeadquarters{
    private String name;

    public FlyingDivision(String name){
        this.name = name;
    }

    @Override
    public String calculateLocation() {
        int pointX = (int) Math.floor(Math.random() * (100 - 1));
        int pointY = (int) Math.floor(Math.random() * (100 - 1));

        return name + ": " + pointX + "." + pointY;
    }
}
