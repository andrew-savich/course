package com.epam.java8.interfaces.defaultmethods;

public interface Interface2 {
    default int method() {
        System.out.println("Method from Interface2");
        return 0;
    }
}
