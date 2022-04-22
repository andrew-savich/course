package com.epam.streams.practice.task4;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

//в каталоге и при нахождении нескольких файлов дессериализовывала их в один list
public class DemoTask4 {
    public static void main(String[] args) {
        String filePath = "Streams/Task4/";

        Person person1 = new Person("Adam");
        Person person2 = new Person("Alex");
        Person person3 = new Person("Edik");
        Person person4 = new Person("Arsen");

        List<Person> persons = new ArrayList<>();

        persons.add(person1);
        persons.add(person2);
        persons.add(person3);
        persons.add(person4);

        System.out.println("Persons: " + persons);

        for (Person person : persons) {
            try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filePath + person.getName() + ".txt"))) {
                out.writeObject(person);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        File[] serializedFiles = new File(filePath).listFiles();

        List<Person> restoredPersons = new ArrayList<>();

        for (File file : serializedFiles) {
            try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(file))) {
                restoredPersons.add((Person) in.readObject());
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Restored persons:" + restoredPersons);

    }
}
