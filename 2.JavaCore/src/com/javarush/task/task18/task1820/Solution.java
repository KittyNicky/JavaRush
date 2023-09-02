package com.javarush.task.task18.task1820;

import java.io.*;
import java.util.ArrayList;

/* 
Округление чисел
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = reader.readLine();
        String fileName2 = reader.readLine();
        reader.close();

        try (BufferedReader readerFile1 = new BufferedReader(new FileReader(fileName1));
             BufferedWriter writerFile2 = new BufferedWriter(new FileWriter(fileName2))) {
            String line;
            while ((line = readerFile1.readLine()) != null) {
                String numbersLine = "";
                for (String s : line.split(" ")) {
                    Double d = Double.parseDouble(s);
                    numbersLine += Math.round(d) + " ";
                }
                writerFile2.write(numbersLine.trim());
            }
        }
    }
}
