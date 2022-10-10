package com.epam.generics.theory.heappolution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Demo {
    public static void main(String[] args) {
        List<String> strings = new ArrayList<>();
        strings.add("Some str");

        List<Integer> integers = (List<Integer>) (Object) strings;//Warning: Unchecked cast: 'java.lang.Object' to 'java.util.List<java.lang.Integer>'

        Integer firstElement = integers.get(0);
    }
}
