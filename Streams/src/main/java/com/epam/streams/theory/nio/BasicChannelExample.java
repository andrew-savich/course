package com.epam.streams.theory.nio;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

//Простой пример как использовать FileChannel для чтения данных в буфер
public class BasicChannelExample {
    public static void main(String[] args) throws IOException {
        RandomAccessFile randomAccessFile = randomAccessFile = new RandomAccessFile("Streams/NioExamples/nio-data.txt", "rw");
        FileChannel fileChannelIn = randomAccessFile.getChannel();

        ByteBuffer byteBuffer = ByteBuffer.allocate(48); //создаём буфер ёмкостью 48 байт

        int byteRead = fileChannelIn.read(byteBuffer); //читаем в буфер

        while (byteRead != -1) {
            System.out.println("Read " + byteRead);
            byteBuffer.flip(); //переключаем буфер в режим чтения

            while (byteBuffer.hasRemaining()) {
                System.out.println((char) byteBuffer.get()); //читаем по одному байту за раз
            }

            byteBuffer.clear(); //очищаем буфер и делаем его готовым к записи

            byteRead = fileChannelIn.read(byteBuffer);
        }

        randomAccessFile.close();

    }

}
