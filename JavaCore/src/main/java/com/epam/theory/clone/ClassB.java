package com.epam.theory.clone;

public class ClassB implements Cloneable{
    int b;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
