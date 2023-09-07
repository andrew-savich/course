package com.epam.theory.clone;

public class ClassA implements Cloneable{
    int a;
    ClassB b = new ClassB();

    @Override
    protected Object clone() throws CloneNotSupportedException {
        ClassA cloned = (ClassA)super.clone();
        cloned.b = (ClassB)cloned.b.clone();
        return super.clone();
    }
}
