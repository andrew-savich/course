package com.epam.multithreading.practice.single;

import java.util.Arrays;
import java.util.List;

public class DemoRace {

    public static void main(String[] args) {

        List<Horse> horses = Arrays.asList(
                new Horse("A", 2),
                new Horse("Q", 1),
                new Horse("Z", 3)
        );
        Race race = new Race(horses, 10);
        race.start();
    }


}
