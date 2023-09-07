package com.andrewsavich.records;

public class RunExample {
    public static void main(String[] args) {
        PersonNew newPerson = new PersonNew("Ivan", "Ivanov", 31);

        System.out.println(newPerson);
        System.out.println(newPerson.age());
    }
}
