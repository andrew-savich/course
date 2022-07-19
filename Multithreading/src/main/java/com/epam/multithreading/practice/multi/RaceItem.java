package com.epam.multithreading.practice.multi;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class RaceItem extends Thread {
    CyclicBarrier barrier;
    private Horse horse;
    private Jokey jokey;
    private boolean stopeRase;
    private String way;

    public RaceItem(Horse horse, Jokey jokey, CyclicBarrier barrier) {
        this.horse = horse;
        this.jokey = jokey;
        stopeRase = false;
        this.barrier = barrier;
        way = "";
    }

    public void run() {
        while (!stopeRase) {
            try {
                barrier.await();
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
            horse.setCurrentSpeed(jokey.changeSpeed());
            addStepsToWay();
        }

    }

    private void addStepsToWay() {
        String additionalSteps = "";
        for (int i = 0; i < horse.getCurrentSpeed(); i++) {
            additionalSteps = additionalSteps + ".";
        }
        way = way + additionalSteps;
    }

    public String getWay() {
        return way;
    }

    public Horse getHorse() {
        return horse;
    }

    public void setStopeRase(boolean stopeRase) {
        this.stopeRase = stopeRase;
    }

    public Jokey getJokey() {
        return jokey;
    }
}
