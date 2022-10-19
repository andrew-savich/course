package com.epam.java8.interfaces.defaultmethods;

public interface Interface1 {
    default void method() {
        System.out.println("Method from Interface1");
    }
}
