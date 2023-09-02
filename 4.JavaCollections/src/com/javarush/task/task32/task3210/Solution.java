package com.javarush.task.task32.task3210;

import java.io.IOException;
import java.io.RandomAccessFile;

/* 
Используем RandomAccessFile
*/

public class Solution {
    public static void main(String... args) {
        String fileName = args[0];
        long number = Long.parseLong(args[1]);
        String text = args[2];

        try (RandomAccessFile randomAccessFile = new RandomAccessFile(fileName, "rw")) {
            if (randomAccessFile.length() < number) number = randomAccessFile.length();
            randomAccessFile.seek(number);

            byte[] buffer = new byte[text.length()];
            randomAccessFile.read(buffer, 0, text.length());
            String bufferText = new String(buffer);

            randomAccessFile.seek(randomAccessFile.length());
            System.out.println(randomAccessFile.getFilePointer());
            if (bufferText.equals(text)) {
                randomAccessFile.write("true".getBytes());
            } else {
                randomAccessFile.write("false".getBytes());
            }
        } catch (IOException e) {
        }
    }
}
