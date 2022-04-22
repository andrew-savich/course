package com.epam.streams.practice.task6;

import java.io.*;

//Чтение файла который лежит в той же папке что и класс таким образом чтобы чтение проходило с конвертацией байт потока в символы и обратно
public class DemoTask6 {
    public static void main(String[] args) {
        String projectPath = System.getProperty("user.dir") + "\\Streams\\src\\main\\java";
        String packagePath = DemoTask6.class.getPackage().toString().replaceAll("\\.", "/").replace("package ", "");
        String className = DemoTask6.class.getSimpleName() + ".txt";

        String fullFilePath = projectPath + "/" + packagePath + "/" + className;
        System.out.println(fullFilePath);

        String someText = "Most of the examples we've seen so far use unbuffered I/O.\n" +
                "This means each read or write request is handled directly by the underlying OS.\n" +
                "This can make a program much less efficient, since each such request often triggers disk access,\n" +
                "network activity, or some other operation that is relatively expensive";

        //пишем строку в файл
        try (FileWriter fileWriter = new FileWriter(new File(fullFilePath))) {
            fileWriter.write(someText);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //читаем байты из файла конвертируя в символы
        try (InputStream in = new FileInputStream(fullFilePath)) {
            int byteElement = -1;

            while ((byteElement = in.read()) != -1) {
                System.out.print((char) byteElement);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        //пишем байты в файл
        try (OutputStream out = new FileOutputStream(fullFilePath + "_bytes")) {
            byte[] bytesText = someText.getBytes();

            out.write(bytesText);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
