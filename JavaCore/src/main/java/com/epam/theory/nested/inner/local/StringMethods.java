package com.epam.theory.nested.inner.local;

import java.util.Comparator;

public class StringMethods {

    public static Comparator<String> getDifferenceLength() {

        class StringLengthComparator implements Comparator<String> {
            @Override
            public int compare(String firstString, String secondString) {
                int result = firstString.length() - secondString.length();

                return result < 0 ? result * -1 : result;
            }
        }

        return new StringLengthComparator();
    }
}
