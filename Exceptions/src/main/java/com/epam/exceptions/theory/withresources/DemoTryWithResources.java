package com.epam.exceptions.theory.withresources;

public class DemoTryWithResources {
    public static void main(String[] args) {
        //Case without resources
        ResourcesClass resource1 = new ResourcesClass();
        try {
            resource1.doSomething();
        } finally {
            resource1.close();
        }

        //Case with resources. Can be without catch/finally block
        try (ResourcesClass resource2 = new ResourcesClass()) {
            resource2.doSomething();
        }


    }
}
