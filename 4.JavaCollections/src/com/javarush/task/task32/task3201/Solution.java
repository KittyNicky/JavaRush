package com.javarush.task.task32.task3201;

import java.io.IOException;
import java.io.RandomAccessFile;

/* 
Запись в существующий файл
*/

public class Solution {
    public static void main(String... args) {
        String fileName = args[0];
        long number = Long.parseLong(args[1]);
        String text = args[2];
        try (RandomAccessFile randomAccessFile = new RandomAccessFile(fileName, "w")) {
            if (randomAccessFile.length() < number) number = randomAccessFile.length();
            randomAccessFile.seek(number);
            byte[] buffer = text.getBytes();
            randomAccessFile.write(buffer);
        } catch (IOException e) {
        }
    }
}
