package com.epam.streams.practice.task7;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

//Попробовать заархивировать файлы программным методом
public class DemoTask7 {
    public static void main(String[] args) throws IOException {

        File fileToZip = new File("Streams", "pom.xml");
        String outPath = "Streams/Out";

        FileService fileService = new FileService();

        fileService.zipFile(fileToZip, outPath);




//        String courseDir = System.getProperty("user.dir") + "/Streams";
//        File outputDir = new File(courseDir + "/Out");
//
//        if (!outputDir.exists()) {
//            outputDir.mkdirs();
//        }
//
//        File[] files = new File(courseDir).listFiles();
//
//        for (File fileToZip : files) {
//            System.out.println(fileToZip.getName());
//            try (ZipOutputStream zipOut = new ZipOutputStream(new FileOutputStream(outputDir + "/" + fileToZip.getName() + ".zip"))) {
//
//                zipOut.putNextEntry(new ZipEntry(fileToZip.getName()));
//
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }

    }
}
