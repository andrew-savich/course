package com.epam.multithreading.practice.multi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Race implements Runnable {
    private List<RaceItem> racers;
    private int timeFrame;
    private String[] tracks;
    private int trackLength;
    private List<RaceItem> winners;
    private boolean started;

    public Race(int timeFrame, int trackLength) {
        racers = new ArrayList<>();
        winners = new ArrayList<>();
        this.timeFrame = timeFrame;
        this.trackLength = trackLength;
        started = false;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(timeFrame);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (!started) {
            System.out.println("START");
            started = true;
        } else {
            clearFrame();
        }
        updateTracks();
        speedTable();
        drawTracks();

        if (!winners.isEmpty()) {
            System.out.println("Winners:");
            for (RaceItem winner : winners) {
                System.out.println(winner.getHorse().getName());
            }
        }
    }

    private void speedTable() {
        for (RaceItem racer : racers) {
            System.out.println(racer.getJokey().getName() + " changed speed " + racer.getHorse().getName() + " to " + racer.getHorse().getCurrentSpeed());
        }
        System.out.println();
    }

    private void updateTracks() {
        for (int trackNum = 0; trackNum < tracks.length; trackNum++) {
            String horseName = racers.get(trackNum).getHorse().getName();
            String currentTrack = tracks[trackNum];
            RaceItem currentRacer = racers.get(trackNum);
            if (currentRacer.getWay().length() + horseName.length() >= currentTrack.length()) {
                tracks[trackNum] = currentRacer.getWay() + horseName;
                for (RaceItem racer : racers) {
                    racer.setStopeRase(true);
                }
                winners.add(currentRacer);
            } else {
                tracks[trackNum] = currentRacer.getWay() + horseName + currentTrack.substring(currentRacer.getWay().length() + horseName.length());
            }
        }
    }

    private void drawTracks() {
        for (String track : tracks) {
            System.out.println(track);
        }
    }

    private void clearFrame() {
        for (int i = 0; i < 5; i++) {
            System.out.println();
        }
    }

    private void buildTracks() {
        tracks = new String[racers.size()];
        for (int trackNum = 0; trackNum < tracks.length; trackNum++) {
            String horseName = racers.get(trackNum).getHorse().getName();
            char[] charTrack = new char[trackLength];
            Arrays.fill(charTrack, ' ');
            tracks[trackNum] = String.valueOf(charTrack).substring(horseName.length()) + "|";
        }
    }

    public void startRace() {
        if(racers.isEmpty()){
            System.out.println("race can not begin without racers");
        } else {
            buildTracks();
            for (RaceItem raceItem : racers) {
                raceItem.start();
            }
        }
    }

    public void setRacers(List<RaceItem> racers) {
        this.racers = racers;
    }
}
