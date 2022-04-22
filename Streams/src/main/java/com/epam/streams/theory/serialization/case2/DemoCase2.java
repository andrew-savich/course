package com.epam.streams.theory.serialization.case2;

import java.io.*;

public class DemoCase2 {
    public static void main(String[] args) {
        String filePath = "Streams/case2.txt";
        Child child = new Child();
        child.setChildId(333);
        child.setParentField(new Parent());

        Child restoredChild = null;

        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filePath));
             ObjectInputStream in = new ObjectInputStream(new FileInputStream(filePath))) {

            out.writeObject(child);

            restoredChild = (Child) in.readObject();

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println("restoredChild: " + restoredChild);

        //Conclussion: java.io.NotSerializableException: com.epam.streams.theory.serialization.case2.Parent
        //because Parent class doesn't implement Serializable
    }
}
