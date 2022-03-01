package com.epam.annotations.theory.example2;

public @interface MyAnnotation {
    int value() default 10;
    int year();
}
