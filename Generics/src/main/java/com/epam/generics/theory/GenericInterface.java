package com.epam.generics.theory;

public interface GenericInterface<T, S extends Object> {
    T someMethod1(S arg);
}
