package com.epam.classloader;

import java.sql.Date;

public class ClassLoaderDemo {
    public static void main(String[] args) {
        ClassLoaderDemo demoObj = new ClassLoaderDemo();
        ClassLoader applicationClassLoader = demoObj.getClass().getClassLoader();
        printClassLoaderDetails(applicationClassLoader);

        // java.sql classes are loaded by platform classloader
        java.sql.Date now = new Date(System.currentTimeMillis());
        ClassLoader platformClassLoder = now.getClass().getClassLoader();
        printClassLoaderDetails(platformClassLoder);

        // java.lang classes are loaded by bootstrap classloader
        ClassLoader bootstrapClassLoder = args.getClass().getClassLoader();
        printClassLoaderDetails(bootstrapClassLoder);
    }

    private static void printClassLoaderDetails(ClassLoader classLoader) {
        if (classLoader != null) {
            //System.out.println("ClassLoader name : " + classLoader.getName());
            System.out.println("ClassLoader class : " + classLoader.getClass().getName());
        } else {
            System.out.println("Bootstrap classloader");
        }
    }
}
