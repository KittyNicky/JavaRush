package com.javarush.task.task18.task1806;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/* 
Исправить ошибки
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream inputStream = new FileInputStream("/Users/nikita.z/myJava/ideaProject/docs/1.txt");
        FileOutputStream outputStream = new FileOutputStream("/Users/nikita.z/myJava/ideaProject/docs/2.txt");

        if (inputStream.available() > 0) {
            byte[] buffer = new byte[inputStream.available()];
            int count = inputStream.read(buffer);
            outputStream.write(buffer, 0, count);
        }

        inputStream.close();
        outputStream.close();
    }
}
