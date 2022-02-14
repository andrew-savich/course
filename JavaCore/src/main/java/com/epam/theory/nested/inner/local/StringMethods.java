package com.epam.theory.nested.inner.local;

import java.util.Comparator;


public class StringMethods {
    private int outerClassField1;
    private static int outerStaticField;


    public Comparator<String> getDifferenceLength() {
        int methodField1 = 1; //effective final (final or doesn't change self value)

        int methodField2 = methodField1;
        methodField2 = 2;


        class StringLengthComparator implements Comparator<String> {
            private int localField1 = outerClassField1; //access to non-static field
            private int localField2 = outerStaticField; //access to static field
            private int localField3 = methodField1;

            //private int localField4 = methodField2; - doesn't work, bcse methodField2 has been changed self value

            //private int localField4 = methodAfterLocalClassField; - has no access to local field, bcse field was defined after inner local class

            @Override
            public int compare(String firstString, String secondString) {
                int result = firstString.length() - secondString.length();
                return result < 0 ? result * -1 : result;
            }
        }

        int methodAfterLocalClassField = 0;

        return new StringLengthComparator();
    }

}
