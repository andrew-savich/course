package com.epam.theory.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class DemoReflection {
    public static void main(String[] args) {
        Person person = new Person(31);

        //изменение значение private поля, которое не имеет setter'a:

        try {
            Field personNameField = person.getClass().getDeclaredField("name");
            personNameField.setAccessible(true);
            personNameField.set(person, "Andrew");
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }

        System.out.println("Changed value of private field: " + person.getName() + "\n");

        //вызов private метода:
        try {
            Method method = person.getClass().getDeclaredMethod("printData");
            method.setAccessible(true);
            method.invoke(person);
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

}
