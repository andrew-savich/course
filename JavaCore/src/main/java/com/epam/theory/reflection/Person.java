package com.epam.theory.reflection;

class Person {
    private int age;
    private String name;

    public Person(int age) {
        this.age = age;
        this.name = "default";
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    private void printData() {
        System.out.println("Person name: " + name + ", age: " + age);
    }
}
