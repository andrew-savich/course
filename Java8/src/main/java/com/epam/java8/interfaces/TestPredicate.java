package com.epam.java8.interfaces;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class TestPredicate {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Smith", "Samueal", "Catley", "Sie");
        Predicate<String> startPredicate = str -> str.startsWith("S");
        Predicate<String> lengthPredicate = str -> str.length() >= 5;
        names.stream()
                .filter(startPredicate.and(lengthPredicate))
                .forEach(System.out::println);
    }
}
