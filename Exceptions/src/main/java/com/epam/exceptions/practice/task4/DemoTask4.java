package com.epam.exceptions.practice.task4;


public class DemoTask4 {
    public static void main(String[] args) {

        System.out.println("Case 1 -Show behavior of finally block if there is one value return from try block and another value return from finally block:");
        //value will return from the finally block
        System.out.println(getCase1());


        System.out.println("Case 2 - Show behavior of finally block if there is one thrown exception from try block and another thrown exception from finally block:");
        //When to handle exception from try block, after invoking app will move to finally block and we will get exception and app will be interrupted
        try{
            getCase2();
        } catch (Exception e){
            System.out.println("Exception from ");
        }

        System.out.println("Case 3 - Show behavior of finally block if there is thrown exception from try block and value return from finally block:");
        //Will be return value from finally block
        getCase3();
    }

    static String getCase1() {
        try {
            System.out.println("try case1");
            return "Value from try block";
        } finally {
            System.out.println("finally case1");
            return "Value from finally block";
        }
    }

    static void getCase2() {
        try{
            System.out.println("try case2");
            throw new RuntimeException();
        } finally {
            System.out.println("finally case2");
            throw new RuntimeException();
        }
    }

    static String getCase3() {
        try{
            System.out.println("try case3");
            throw new RuntimeException();
        } finally {
            System.out.println("finally case3");
            return "Value from finally case 3";
        }
    }
}
