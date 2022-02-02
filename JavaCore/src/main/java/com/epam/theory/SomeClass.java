package com.epam.theory;

public class SomeClass {
   static {
        System.out.println("initial block");
    }

    private int i = 1;

    public SomeClass() {
        System.out.println("Constructor");
        System.out.println("constructor i: " + this.i);
    }

    //abstract void someMethod();
}
