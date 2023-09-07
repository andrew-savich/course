package com.andrewsavich.java9;

import java.util.Arrays;
import java.util.List;


public class ImmutableCollectionExapmles {
    public static void main(String[] args) {
        List<Integer> nums1 = List.of(1, 2, 3, 4);
//        nums1.add(5); - java.lang.UnsupportedOperationException during executing
//        nums1.set(0, 111); - java.lang.UnsupportedOperationException during executing
        List<Integer> nums2 = Arrays.asList(1, 2, 3, 4);
        nums2.set(0, 0); //-worked case
    }
}
