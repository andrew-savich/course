package com.epam.annotations.theory.example;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface MyNewAnnotation {
    String message() default "Default message";
    int value() default 0;
}
