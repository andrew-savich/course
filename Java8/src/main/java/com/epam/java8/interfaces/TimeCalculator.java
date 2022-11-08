package com.epam.java8.interfaces;

import java.time.LocalTime;

public class TimeCalculator {
    public static void main(String[] args) {
        LocalTime start = LocalTime.of(23, 35, 34);
        LocalTime end = LocalTime.of(03, 45, 05);

        int startSecs = start.getHour() * 3600 + start.getMinute() * 60 + start.getSecond();
        int endSecs = end.getHour() * 3600 + end.getMinute() * 60 + end.getSecond();
        int range = endSecs - startSecs;

        int hours = range / 3600;
        int minutes = (range - hours * 3600) / 60;
        int seconds = range - hours * 3600 - minutes * 60;

        if (hours < 0 && minutes < 0 && seconds < 0) {
            hours = 23 + hours;
            minutes = 59 + minutes;
            seconds = 60 + seconds;
        }

            System.out.println(hours + ":" + minutes + ":" + seconds);

    }
}
