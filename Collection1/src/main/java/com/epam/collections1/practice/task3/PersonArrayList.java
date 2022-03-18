package com.epam.collections1.practice.task3;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PersonArrayList implements Iterable<Person> {
    private List<Person> persons;

    public PersonArrayList() {
        this.persons = new ArrayList<>();
    }

    public void addPerson(Person person) {
        persons.add(person);
    }

    public boolean removePerson(Person person) {
        return persons.remove(person);
    }

    public Person getPerson(int index) {
        return persons.get(index);
    }

    @Override
    public Iterator<Person> iterator() {
        return persons.iterator();
    }
}
