package com.epam.generics.practice;

public class NonGenericClassWithGenericConstructor {
    public <T> NonGenericClassWithGenericConstructor(T arg) {
        System.out.println(this.getClass().getSimpleName() + ": with arg: '" + arg + "' of type: " + arg.getClass().getSimpleName());
    }
}
