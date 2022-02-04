package com.epam.theory.classclass;

import java.lang.reflect.Field;

public class DemoClass {
    public static void main(String[] args) {
        Car car = new Car("Volvo", Fuel.PETROL);

        //Получение экземпляра класса Class
        //Способ #1:
        try {
            Class<?> carClass1 = Class.forName("com.epam.theory.classclass.Car");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        //Способ #2:
        Class<? extends Car> carClass2 = car.getClass();

        //Способ #3:
        Class<Car> carClass3 = Car.class;

        //Получение информации о переменных класса можно с помощью методов:
        //#1 getDeclaredFields():
        System.out.println("getDeclaredFields():");
        Field[] declaredFields = carClass3.getDeclaredFields();
        for (Field field : declaredFields) {
            System.out.println(field);
        }

        //#2 getDeclaredField():
        System.out.println("\ngetDeclaredField():");
        try {
            Field nameField = carClass3.getDeclaredField("name");
            System.out.println("nameField:" + nameField);
            Field notExistField = carClass3.getDeclaredField("notExistField");
        } catch (NoSuchFieldException e) {
            System.out.println(e);
        }

        //#3 getFields():
        System.out.println("\ngetFields():");
        Field[] fields = carClass3.getFields();
        for (Field field : fields) {
            System.out.println(field);
        }

        //#4 getField()
        System.out.println("\ngetField():");
        try {
            Field engineStartedField = carClass3.getField("engineStarted");
            System.out.println(engineStartedField);
            Field name = carClass3.getField("name");
        } catch (NoSuchFieldException e) {
            System.out.println(e);
        }
    }
}
