package com.epam.theory.nested.inner.anonymous;

public class OneTimeWorker implements Worker{
    @Override
    public void doWork() {
        System.out.println("to do one-time work");
    }
}
