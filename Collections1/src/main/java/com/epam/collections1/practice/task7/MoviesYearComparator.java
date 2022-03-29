package com.epam.collections1.practice.task7;

import java.util.Comparator;

public class MoviesYearComparator implements Comparator<Movie> {
    @Override
    public int compare(Movie o1, Movie o2) {
        return o1.getYear() - o2.getYear();
    }
}
