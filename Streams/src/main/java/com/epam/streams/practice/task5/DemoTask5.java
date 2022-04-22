package com.epam.streams.practice.task5;

import java.io.*;

//Поменять класс на final и удалить Serializeble, и все равно найти способ сериализовать файл
public class DemoTask5 {
    public static void main(String[] args) {
        String filePath = "Streams/task5.txt";

        Employee employee = new Employee("Peter");

        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filePath));
             ObjectInputStream in = new ObjectInputStream(new FileInputStream(filePath))) {

            out.writeObject(employee);

            System.out.println("Restored employee: " + (Employee) in.readObject());

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
