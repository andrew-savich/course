package com.epam.generics.practice;

public class GenericClassWithGenericConstructor<T> {
    public <S> GenericClassWithGenericConstructor(S arg) {
        System.out.println(this.getClass().getSimpleName() + ": with arg: '" + arg + "' of type: " + arg.getClass().getSimpleName());
    }
}
