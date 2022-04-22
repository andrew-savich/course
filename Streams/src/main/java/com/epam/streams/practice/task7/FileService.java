package com.epam.streams.practice.task7;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class FileService {
    public void zipFile(File fileToZip, String outFolderPath) {
        try (FileInputStream fileInputStream = new FileInputStream(fileToZip);
             FileOutputStream fileOutputStream = new FileOutputStream(new File(outFolderPath, fileToZip.getName() + "_compressed.zip"));
             ZipOutputStream zipOut = new ZipOutputStream(fileOutputStream)) {

            ZipEntry zipEntry = new ZipEntry(fileToZip.getName());
            zipOut.putNextEntry(zipEntry);

            byte[] bytes = new byte[1024];
            int length;

            while ((length = fileInputStream.read(bytes)) >= 0) {
                zipOut.write(bytes, 0, length);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
