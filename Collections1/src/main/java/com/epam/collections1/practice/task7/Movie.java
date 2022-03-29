package com.epam.collections1.practice.task7;

public class Movie implements Comparable<Movie>{
    private String name;
    private int year;
    private double rate;

    public Movie(String name, int year, double rate) {
        this.name = name;
        this.year = year;
        this.rate = rate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "name='" + name + '\'' +
                ", year=" + year +
                ", rate=" + rate +
                '}';
    }

    @Override
    public int compareTo(Movie o) {
        return this.getName().compareTo(o.getName());
    }
}
