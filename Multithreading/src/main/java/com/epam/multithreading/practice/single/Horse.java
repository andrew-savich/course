package com.epam.multithreading.practice.single;

public class Horse {
    private String horseName;
    private int currentSpeed;
    private boolean isStepped;
    private int position;
    private String way;
    private int maxSpeed;

    public Horse(String horseName, int currentSpeed) {
        way = horseName;
        position = 0;
        isStepped = false;
        this.horseName = horseName;
        this.currentSpeed = currentSpeed;
    }

    public String getName() {
        return horseName;
    }

    public int getCurrentSpeed() {
        return currentSpeed;
    }

    public boolean isStepped() {
        return isStepped;
    }

    public void setStepped(boolean stepped) {
        isStepped = stepped;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public String getWay() {
        return way;
    }

    public void setWay(String way) {
        this.way = way;
    }

    public void setCurrentSpeed(int currentSpeed) {
        this.currentSpeed = currentSpeed;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }
}
