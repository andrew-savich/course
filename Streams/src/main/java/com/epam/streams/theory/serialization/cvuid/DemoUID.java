package com.epam.streams.theory.serialization.cvuid;

import java.io.*;

public class DemoUID {
    public static void main(String[] args) {
        String filePath = "Streams/uid.txt";

        //Person person = new Person("Xxx");
        Person restoredPerson = null;

        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(filePath))) {
            restoredPerson = (Person) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println(restoredPerson);

    }
    //Вывод: После сериализцации экземпляра класса мы изменим класс (добавим поле, уберем существующее поле), без определенного serialVersionUID
    //то при десериализации получим InvalidClassException, тк класс изменен и для него будет неявно сгенерирован новый UID, который не соответствует в сериализовонном объекте
    //Но если мы явно определим UID, зададим ему значение, сериализуем объект, изменим класс, и не изменим версию класса (serialVersionUID), то объект сможет
    //десериализоваться без исключений. Если было добавленно новое поле, оно проинициализируется значением по умолчанию, а удаленное поле просто проигнарируется
}
