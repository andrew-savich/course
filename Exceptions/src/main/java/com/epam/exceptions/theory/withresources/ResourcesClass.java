package com.epam.exceptions.theory.withresources;

public class ResourcesClass implements AutoCloseable{
    @Override
    public void close(){
        try{
            System.out.println("Closing resources...");
        } catch (Exception e){
            System.out.println("Exception during closing resources: ");
            e.printStackTrace();
        }
    }

    public void doSomething(){
        System.out.println("Do something");
    }
}
