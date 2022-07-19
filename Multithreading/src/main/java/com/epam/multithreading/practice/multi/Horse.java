package com.epam.multithreading.practice.multi;

public class Horse {
    private String name;
    private int currentSpeed;
    private final int MIN_SPEED = 1;
    private final int MAX_SPEED = 3;

    public Horse(String name) {
        this.name = name;
        currentSpeed = 0;
    }

    public String getName() {
        return name;
    }

    public int getCurrentSpeed() {
        return currentSpeed;
    }

    public void setCurrentSpeed(int speed) {
        int speedForChange = currentSpeed + speed;

        if (speedForChange > MAX_SPEED) {
            currentSpeed = MAX_SPEED;
        } else {
            if (speedForChange < MIN_SPEED) {
                currentSpeed = MIN_SPEED;
            } else {
                currentSpeed = speedForChange;
            }
        }
    }
}
