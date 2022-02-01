package com.epam.task2.divisions;

public class InfantryDivision extends MilitaryHeadquarters {
    private String name;

    public InfantryDivision(String name) {
        this.name = name;
    }

    @Override
    public String calculateLocation() {
        int pointX = (int) Math.floor(Math.random() * (100 - 1));
        int pointY = (int) Math.floor(Math.random() * (100 - 1));

        return name + ": " + pointX + "." + pointY;
    }
}
