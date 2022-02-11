package com.epam.theory.nested.inner.local;

import java.util.Comparator;

public class StringMethods {
    static int one;
    int two;

    public Comparator<String> getDifferenceLength() {
        int three = 3;
        //three = 4;

        class StringLengthComparator implements Comparator<String> {

            @Override
            public int compare(String firstString, String secondString) {
                int result = firstString.length() - secondString.length();

                one = 1;
                two = 2;
                int local = three;

                return result < 0 ? result * -1 : result;
            }
        }

        return new StringLengthComparator();
    }
}
