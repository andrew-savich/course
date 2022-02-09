package com.epam.theory.inheritance.problem;

public interface Interfase {
    default void sameMethod() {
        System.out.println("This is default method");
    }
}
