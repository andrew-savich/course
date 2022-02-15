package com.epam.exceptions.practice.task2;

public class MyError extends OutOfMemoryError{
    public MyError(String message) {
        super(message);
    }
}
