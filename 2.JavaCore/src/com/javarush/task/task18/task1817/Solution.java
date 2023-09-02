package com.javarush.task.task18.task1817;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;

/* 
Пробелы
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        if (args.length == 0) return;
        String fileName = args[0];
        int countSymbols = 0;
        int countSpaces = 0;
        int c;
        try (FileInputStream fileInputStream = new FileInputStream(fileName)) {
            while (fileInputStream.available() > 0) {
                c = fileInputStream.read();
                if (c == 32) countSpaces++;
                countSymbols++;
            }
        }
        float result = (float) countSpaces / countSymbols * 100;
        System.out.printf("%.2f", result);
    }
}
