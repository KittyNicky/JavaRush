package com.javarush.task.task18.task1825;

import java.io.*;
import java.util.*;

/* 
Собираем файл
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Set<String> set = new TreeSet<>();
        String inputFileName;
        String outputFileName = null;
        while (!(inputFileName = reader.readLine()).equals("end")) {
            set.add(inputFileName);
            if (outputFileName == null)
                outputFileName = inputFileName.split(".part")[0];
        }
        try (FileOutputStream fileOutputStream = new FileOutputStream(outputFileName)) {
            for (String fileName : set) {
                try (FileInputStream fileInputStream = new FileInputStream(fileName)) {
                    byte[] buffer = new byte[fileInputStream.available()];
                    while (fileInputStream.available() > 0) {
                        int lenBuffer = fileInputStream.read(buffer);
                        fileOutputStream.write(buffer, 0, lenBuffer);
                    }
                }
            }
        }
    }
}
