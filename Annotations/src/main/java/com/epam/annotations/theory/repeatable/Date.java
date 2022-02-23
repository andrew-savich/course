package com.epam.annotations.theory.repeatable;

import java.lang.annotation.Repeatable;

@Repeatable(Dates.class)
public @interface Date {
    int day();
    int month();
    int year();
}
