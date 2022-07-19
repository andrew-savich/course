package com.epam.multithreading.practice.multi;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CyclicBarrier;

public class StartRace {
    public static void main(String[] args) {
        Race race = new Race(800, 30);
        CyclicBarrier barrier = new CyclicBarrier(5, race);

        Horse horse1 = new Horse("horse1");
        Horse horse2 = new Horse("horse2");
        Horse horse3 = new Horse("horse3");
        Horse horse4 = new Horse("horse4");
        Horse horse5 = new Horse("horse5");
        Jokey jokey1 = new Jokey("jokey1");
        Jokey jokey2 = new Jokey("jokey2");
        Jokey jokey3 = new Jokey("jokey3");
        Jokey jokey4 = new Jokey("jokey4");
        Jokey jokey5 = new Jokey("jokey5");

        RaceItem racer1 = new RaceItem(horse1, jokey1, barrier);
        RaceItem racer2 = new RaceItem(horse2, jokey2, barrier);
        RaceItem racer3 = new RaceItem(horse3, jokey3, barrier);
        RaceItem racer4 = new RaceItem(horse4, jokey4, barrier);
        RaceItem racer5 = new RaceItem(horse5, jokey5, barrier);

        List<RaceItem> racers = Arrays.asList(racer1, racer2, racer3, racer4, racer5);
        race.setRacers(racers);

        race.startRace();
    }
}
