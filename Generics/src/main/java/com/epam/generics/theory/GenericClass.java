package com.epam.generics.theory;

public class GenericClass<T, S extends Number> implements GenericInterface<String, Long> {

    private T field1;
    private S numValueField;

    @Override
    public String someMethod1(Long arg) {
        return "Some returning string";
    }
}
