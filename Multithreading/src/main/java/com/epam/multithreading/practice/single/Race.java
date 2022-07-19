package com.epam.multithreading.practice.single;

import java.util.List;
import java.util.Objects;

public class Race extends Thread {
    private List<Horse> horses;
    private int frames;
    private int currentFrame;
    private String track;
    private int trackLength;
    private Horse winner;

    public Race(List<Horse> horses, int frames) {
        winner = null;
        this.horses = horses;
        this.frames = frames;
        currentFrame = 0;
        trackLength = frames * 3;
        buildTrack();
    }

    public void run() {
        draw();
        while (currentFrame < frames && Objects.isNull(winner)) {
            try {
                Thread.sleep(500);
                for (Horse horse : horses) {
                    int nextPosition = horse.getWay().length() + horse.getCurrentSpeed();
                    if (nextPosition >= trackLength) {
                        int lastSteps = trackLength - horse.getWay().length();
                        winner = horse;
                        horse.setWay(horse.getWay().replace(horse.getName(), "."));
                        horse.setWay(horse.getWay() + Steps.getSteps(lastSteps) + horse.getName());
                    } else {
                        horse.setWay(horse.getWay().replace(horse.getName(), "."));
                        horse.setWay(horse.getWay() + Steps.getSteps(horse.getCurrentSpeed()) + horse.getName());
                    }
                }
                draw();
                currentFrame++;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Winner: " + winner.getName());

    }

    private void buildTrack() {
        track = "";
        for (int step = 0; step < trackLength; step++) {
            track = track + " ";
        }
        track = track + "|";
    }

    private void draw() {
        for (int numStrings = 0; numStrings < 100; numStrings++) {
            System.out.println();
        }

        for (Horse horse : horses) {
            String currentTrack = horse.getWay() + track.substring(horse.getWay().length());
            System.out.println(currentTrack);
        }
    }
}
