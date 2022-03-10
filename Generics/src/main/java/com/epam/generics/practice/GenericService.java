package com.epam.generics.practice;

import java.util.List;

public class GenericService {
    public <T extends Number> Long sumOfList(List<T> list) {
        Long sum = 0L;

        for (T item : list) {
            sum += item.longValue();
        }

        return sum;
    }

    public void printObjectElements(List<Object> list) {
        for (Object item : list) {
            System.out.println(item);
        }
    }

    public void printUnknownElements(List<?> list) {
        for (Object item : list) {
            System.out.println(item);
        }
    }

    public Long accumLongs(List<? extends Number> list) {
        Long sum = 0L;

        if (!list.isEmpty() && list.get(0).getClass().getSimpleName().equals("Long")) {
            for (Number item : list) {
                sum += item.longValue();
            }
        }

        return sum;
    }

    public void insertFixedValuesToList(List<? super Integer> list) {
        list.add(111);
        list.add(222);
        list.add(333);
        list.add(444);
        list.add(555);
    }

}
