package com.epam.multithreading.practice.single;

public class Steps {
    private final static String ONE = ".";
    private final static String TWO = "..";
    private final static String THREE = "...";

    public static String getSteps(int speed) {
        switch (speed) {
            case 1:
                return ONE;
            case 2:
                return TWO;
            case 3:
                return THREE;
            default:
                return "";
        }
    }
}
