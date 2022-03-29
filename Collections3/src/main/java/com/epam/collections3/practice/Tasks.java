package com.epam.collections3.practice;

import java.util.*;

public class Tasks {
    public static void main(String[] args) {
        //Create HashMap by different constructors
        HashMap<Integer, String> hashMap1 = new HashMap<>(); //simple empty
        HashMap<Integer, String> hashMap2 = new HashMap<>(32, 0.5f); //with initialCapacity and loadFactory
        HashMap<Integer, String> hashMap3 = new HashMap<>(64); //only with initialCapacity


        //Try to add null to HashMap as key and value
        hashMap1.put(null, null);
        hashMap1.put(null, "some value");

        System.out.println(hashMap1); //output {null=some value} - override value by key 'null'


        //Create LinkedHashMap by different constructors
        LinkedHashMap<Integer, String> linkedHashMap1 = new LinkedHashMap<>(); //simple
        LinkedHashMap<Integer, String> linkedHashMap2 = new LinkedHashMap<>(32, 0.5f); ////with initialCapacity and loadFactory
        LinkedHashMap<Integer, String> linkedHashMap3 = new LinkedHashMap<>(64); //only with initialCapacity
        LinkedHashMap<Integer, String> linkedHashMap4 = new LinkedHashMap<>(hashMap1); //from another HashMap


        //Create TreeMap by different constructors
        TreeMap<Integer, String> treeMap1 = new TreeMap<>(); //simple

        class Person {
            int age;
        }

        TreeMap<Person, Integer> personNumberMap = new TreeMap<>(new Comparator<Person>() {

            @Override
            public int compare(Person o1, Person o2) {
                return o1.age - o2.age;
            }
        }); //with anonymous comparator


        //Use Collections methods: emptyMap, singletonMap, unmodifiableMap
        Map<Integer, String> emptyMap = Collections.emptyMap(); // - empty unmodified map
        //emptyMap.put(1, "one"); - UnsupportedOperationException
        System.out.println("emptyMap: " + emptyMap);

        Map<Integer, String> singletonMap = Collections.singletonMap(1, "one");
        //singletonMap.put(2, "two"); - UnsupportedOperationException
        System.out.println("singletonMap: " + singletonMap);

        Map<Integer, String> unmodifiableMap = Collections.unmodifiableMap(hashMap1);
        //unmodifiableMap.put(2, "two"); UnsupportedOperationException
        System.out.println("unmodifiableMap: " + unmodifiableMap);


        //Use Map methods on HashMap object
        System.out.println("isEmpty(): " + hashMap1.isEmpty());
        System.out.println("size(): : " + hashMap1.size());
        hashMap1.put(2, "two");
        System.out.println("containsKey(): " + hashMap1.containsKey(2));
        System.out.println("containsValue(): " + hashMap1.containsValue("two"));
        System.out.println("get(): " + hashMap1.get(null));
        hashMap1.remove(null);

    }
}
