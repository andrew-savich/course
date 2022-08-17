package com.epam.collections1.practice;

import com.epam.collections1.practice.task3.Person;
import com.epam.collections1.practice.task3.PersonArrayList;
import com.epam.collections1.practice.task7.Movie;
import com.epam.collections1.practice.task7.MoviesYearComparator;

import java.util.*;

public class Tasks {
    public static void main(String[] args) {
        //Convert array to String with toString and with Arrays.toString
        int[] someArray1 = new int[]{1, 2, 3, 4, 5};

        System.out.println("toString: " + someArray1.toString());
        System.out.println("Arrays.toString: " + Arrays.toString(someArray1));


        //Use Collection methods on ArrayList object
        ArrayList<String> someArrayList1 = new ArrayList();

        //add(E o) - add object of type E to ArrayList
        someArrayList1.add("one");
        someArrayList1.add("two");
        someArrayList1.add("three");
        someArrayList1.add("four");

        //E get(int index); - get element by index
        System.out.println("someArrayList1.get(0): " + someArrayList1.get(0));

        //boolean contains(Object obj) - returns true/false if contains obj
        System.out.println("someArrayList1.contains(\"four\"): " + someArrayList1.contains("four"));

        //int size() - returns the number of elements in this collection
        System.out.println("someArrayList1.size(): " + someArrayList1.size());

        //boolean isEmpty() - return true if collection has no elements
        System.out.println("someArrayList1.isEmpty(): " + someArrayList1.isEmpty());

        //boolean remove(Object obj) - removes obj from collection, if success returns true
        System.out.println("someArrayList1.remove(\"four\"): " + someArrayList1.remove("four"));

        //void clear() - cleans a collection
        someArrayList1.clear();


        //Implement Iterator and Iterable
        PersonArrayList personArrayList = new PersonArrayList();
        personArrayList.addPerson(new Person(18, "Ivan"));
        personArrayList.addPerson(new Person(22, "Anna"));
        personArrayList.addPerson(new Person(41, "Petr"));
        personArrayList.addPerson(new Person(36, "Elena"));

        for (Person person : personArrayList) {
            System.out.println(person);
        }

        Iterator<Person> personIterator = personArrayList.iterator();

        while (personIterator.hasNext()) {
            System.out.println(personIterator.next());
        }

        //Использовать ListIterator
        List<String> strings = new ArrayList<>();
        strings.add("one");
        strings.add("two");
        strings.add("three");
        strings.add("four");

        ListIterator<String> stringsListIterator = strings.listIterator();

        while (stringsListIterator.hasNext()) {
            int index = stringsListIterator.nextIndex();
            String current = stringsListIterator.next();
            System.out.println(current);
            stringsListIterator.set(current + " - edited element with index: " + index);
        }

        while (stringsListIterator.hasPrevious()) {
            System.out.println(stringsListIterator.previous());
        }


        //Create List from an array with Arrays.asList
        List<String> strings2 = Arrays.asList("str1", "str2", "str3");


        //Remove an element from ArrayList inside for-each loop and get ConcurrentModificationException
        try {
            for (String str : strings) {
                strings.remove(str);
            }
        } catch (ConcurrentModificationException e) {
            System.out.println("Was catched \"ConcurrentModificationException\"");
        }


        //Implement Comparator and Comparable + Use Collections.sort and List.sort
        List<Movie> movies = Arrays.asList(
                new Movie("The Godfather", 1972, 9.2),
                new Movie("Mad Max", 2015, 8.1),
                new Movie("The Lord of the Rings", 2001, 8.8),
                new Movie("Saving Private Ryan", 1998, 8.6)
        );

        TreeSet<Movie> movieSet = new TreeSet<>(movies);
        System.out.println("\nNatural sort in the set by implemented Comparable in the class Movie:");
        for (Movie movie : movieSet) {
            System.out.println(movie);
        }

        movies.sort(new MoviesYearComparator());
        System.out.println("\nSorted movies by year using MoviesYearComparator");
        for (Movie movie : movies) {
            System.out.println(movie);
        }

        Collections.sort(movies, new Comparator<Movie>() {
            @Override
            public int compare(Movie o1, Movie o2) {
                if (o1.getRate() > o2.getRate()) {
                    return 1;
                }

                if (o1.getRate() < o2.getRate()) {
                    return -1;
                }

                return 0;
            }
        });

        System.out.println("\nSorted movies by rate using Anonymous class of Comparator");
        for (Movie movie : movies) {
            System.out.println(movie);
        }

        //Immutable
        List<Integer> simpleList = new ArrayList<>();
        simpleList.add(1);
        simpleList.add(2);
        simpleList.add(3);
        simpleList.add(4);
        simpleList.add(5);
        simpleList.add(6);

        List<Integer> unmodifiableList = Collections.unmodifiableList(simpleList);

        simpleList.add(7);

        System.out.println(unmodifiableList); // - "7" will be in the unmodifiableList

    }
}
