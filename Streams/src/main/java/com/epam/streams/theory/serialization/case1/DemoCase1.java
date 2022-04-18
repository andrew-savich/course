package com.epam.streams.theory.serialization.case1;

import java.io.*;

public class DemoCase1 {
    public static void main(String[] args) {
        String filePath = "Streams/parent1.txt";
        Parent parent = new Parent();
        parent.setParentId(333);
        parent.setChild(new Child(666));

        System.out.println("parent: " + parent); //parent: Parent{parentId=333, child=Child{childId=666}}

        Parent restoredParent;

        try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filePath));
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(filePath))) {
            out.writeObject(parent);

            restoredParent = (Parent) in.readObject();

            System.out.println("restoredParent: " + restoredParent); //restoredParent: Parent{parentId=333, child=Child{childId=666}}
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
