package com.epam.exceptions.practice.task2;

public class DemoTask2 {
    public static void main(String[] args) {
        //Errors are unchecked exception and compiler doesn't tell us to process this exception,
        //But when we process this error, after that program works like with regular exceptions
        try{
            throw new MyError("Trying generate error");
        } catch (MyError e){
            System.out.println("Was caught error: " + e);
        }

    }
}
