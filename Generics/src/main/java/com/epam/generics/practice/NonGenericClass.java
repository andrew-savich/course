package com.epam.generics.practice;

public class NonGenericClass {
    public <T> void genericMethod(T arg) {
        System.out.println(this.getClass().getSimpleName() + ": with arg: '" + arg + "' of type: " + arg.getClass().getSimpleName());
    }
}
