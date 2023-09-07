package com.epam.theory.clone;

public class Demo {
    public static void main(String[] args)  throws CloneNotSupportedException{
        ClassA objA1 = new ClassA();
        ClassA objA2;

        objA2 = (ClassA) objA1.clone();

        System.out.println(objA2.b.b);
        objA2.b.b = 5;
        System.out.println(objA1.b.b);
        System.out.println(objA1.b == objA2.b);
    }
}
