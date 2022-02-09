package com.epam.theory.constructors.problem;

public class ProblemDemo {
    public static void main(String[] args) {
        ClassWithoutConstructor someObject = new ClassWithoutConstructor();
        String someField = "some value";

        //someObject.setSomeField(someField);

        System.out.println("equals: " + someObject.getSomeField().equals(someField));

    }
}
