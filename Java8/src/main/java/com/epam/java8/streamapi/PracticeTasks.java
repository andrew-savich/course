package com.epam.java8.streamapi;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class PracticeTasks {
    public static void main(String[] args) {
        //1) Create a stream of integers and filter out all even numbers
        List<Integer> evens = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
                .filter(num -> num % 2 == 0)
                .collect(Collectors.toList());
        System.out.println("1) Create a stream of integers and filter out all even numbers:\n" + evens);

        //2) Create a stream of strings and convert each string to uppercase
        List<String> strings = Arrays.asList("Some String 11111111", "Some String 222", "Some String 333333", "Some String 4");
        List<String> upperCaseStrings = strings.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());
        System.out.println("2) Create a stream of strings and convert each string to uppercase:\n" + upperCaseStrings);

        //3) Generate a stream of integers from 1 to 100
        List<Integer> hundredIntegers = IntStream
                .range(1, 101)
                .boxed()
                .collect(Collectors.toList());
        System.out.println("3) Generate a stream of integers from 1 to 100:\n" + hundredIntegers);

        //4) Collect all even numbers from a list into another list using streams
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> evens2 = integers.stream()
                .filter(num -> num % 2 == 0)
                .collect(Collectors.toList());
        System.out.println("4) Collect all even numbers from a list into another list using streams:\n" + evens2);

        //5) Calculate the sum of a list of integers using streams
        int sum = integers.stream()
                .mapToInt(Integer::intValue)
                .sum();
        System.out.println("5) Calculate the sum of a list of integers using streams: \n" + sum);

        //6) Convert a list of strings to a list of integers representing the length of each string
        List<Integer> stringLengthes = strings.stream()
                .map(String::length)
                .collect(Collectors.toList());
        System.out.println("6) Convert a list of strings to a list of integers representing the length of each string:\n" + stringLengthes);

        //7) Count the number of elements in a list that satisfy a given predicate
        List<Integer> satisfiedElements = integers.stream()
                .filter(num -> num % 3 == 0)
                .collect(Collectors.toList());
        System.out.println("7) Count the number of elements in a list that satisfy a given predicate:\n" + satisfiedElements);

        //8) Find the maximum and minimum values in a list of integers using streams.
        int min = integers.stream()
                .mapToInt(Integer::intValue)
                .min()
                .orElseThrow(NoSuchElementException::new);
        int max = integers.stream()
                .mapToInt(Integer::intValue)
                .max()
                .orElseThrow(NoSuchElementException::new);
        System.out.println("8) Find the maximum and minimum values in a list of integers using streams:\n" + "min : " + min + " max: " + max);

        //9) Concatenate all strings from a list into a single string using streams
        String concatedString = strings.stream()
                .collect(Collectors.joining());
        System.out.println("9) Concatenate all strings from a list into a single string using streams:\n" + concatedString);

        //10) Create a stream of random numbers and limit it to the first 10 numbers
        Random random = new Random();
        Stream<Integer> randoms = Stream.generate(random::nextInt).limit(10);
        System.out.println("10) Create a stream of random numbers and limit it to the first 10 numbers:");
        randoms.forEach(str -> System.out.print(str + ", "));

        //11) Map a list of strings to their lowercase equivalents using streams
        List<String> lowerCaseString = strings.stream()
                .map(String::toLowerCase)
                .collect(Collectors.toList());
        System.out.println("11) Map a list of strings to their lowercase equivalents using streams:\n" + lowerCaseString);

        //13) Perform a set operation (union, intersection, difference) on two lists using streams
        List<Integer> list1 = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> list2 = Arrays.asList(4, 5, 6, 7, 8);

        List<Integer> unioned = Stream.concat(list1.stream(), list2.stream())
                .collect(Collectors.toList());
        List<Integer> intersection = list1.stream()
                .filter(list2::contains)
                .collect(Collectors.toList());
        List<Integer> different = list1.stream()
                .filter(num -> !list2.contains(num))
                .collect(Collectors.toList());
        System.out.println("13) Perform a set operation (union, intersection, difference) on two lists using streams:\n"
                + "unioned: " + unioned + "\nintersection: " + intersection + "\ndifferent: " + different);

        //14) Partition a list of integers into two lists based on whether they are even or odd
        Map<Boolean, List<Integer>> partitionedMap = integers.stream()
                .collect(Collectors.partitioningBy(i -> i % 2 == 0));
        List<Integer> eventList = partitionedMap.get(true);
        List<Integer> oddtList = partitionedMap.get(false);
        System.out.println("14) Partition a list of integers into two lists based on whether they are even or odd:\n" +
                "eventList" + eventList + "\noddtList: " + oddtList);

        //21) Sort a list of strings based on their length using streams
        List<String> sortedByLength = strings.stream()
                .sorted((str1, str2) -> str2.length() - str1.length())
                .collect(Collectors.toList());

        System.out.println("21) Sort a list of strings based on their length using streams:\n" + sortedByLength);

        //20) Use flatMap to flatten a list of lists into a single list
        List<List<Integer>> listOfLists = Arrays.asList(
                Arrays.asList(1, 2, 3),
                Arrays.asList(4, 5, 6),
                Arrays.asList(7, 8, 9)
        );
        List<Integer> wholeElements = listOfLists.stream()
                .flatMap(List::stream)
                .collect(Collectors.toList());
        System.out.println("20) Use flatMap to flatten a list of lists into a single list:\n" + wholeElements);

        //22) Sort a list of objects based on a property of the object
        class Person {
            private int age;

            public Person(int age) {
                this.age = age;
            }

            public int getAge() {
                return age;
            }

            @Override
            public String toString() {
                return "Person{" +
                        "age=" + age +
                        '}';
            }
        }
        List<Person> people = Arrays.asList(new Person(9), new Person(55), new Person(18));
        List<Person> sortedPeople = people.stream()
                .sorted(Comparator.comparingInt(Person::getAge))
                .collect(Collectors.toList());
        System.out.println("22) Sort a list of objects based on a property of the object:\n" + sortedPeople);

        //25) Remove duplicate elements from a list using streams
        List<Integer> integersWithDuplicates = Arrays.asList(1, 2, 3, 4, 4, 4, 5, 6, 7, 7, 7, 8, 9);
        List<Integer> distincst = integersWithDuplicates.stream()
                .distinct()
                .collect(Collectors.toList());
        System.out.println("25) Remove duplicate elements from a list using streams:\n" + distincst);

        //26) Create a stream of integers and skip the first N elements
        List<Integer> skippedList = integers.stream()
                .skip(3)
                .collect(Collectors.toList());
        System.out.println("26) Create a stream of integers and skip the first N elements:\n" + skippedList);

        //27) Create a stream of strings and remove all strings that contain a specific character
        List<String> strings2 = Arrays.asList("Some", "Any", "Nothing", "Anything");
        Character specialCharacter = 'o';
        List<String> filteredStrings = strings2.stream()
                .filter(str -> !str.contains(specialCharacter.toString()))
                .collect(Collectors.toList());
        System.out.println("27) Create a stream of strings and remove all strings that contain a specific character:\n" + filteredStrings);

        //28) Retrieve the first element of a stream that satisfies a given predicate
        int firstFoundElement = integers.stream()
                .filter(num -> num > 5)
                .findFirst()
                .orElseThrow(NoSuchElementException::new);
        System.out.println("28) Retrieve the first element of a stream that satisfies a given predicate:\n" + firstFoundElement);

        //29) Convert a list of integers to an array using streams
        Integer[] intArray = integers.stream()
                .toArray(Integer[]::new);
    }
}
