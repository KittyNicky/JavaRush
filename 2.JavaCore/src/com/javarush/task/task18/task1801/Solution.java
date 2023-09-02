package com.javarush.task.task18.task1801;

import java.io.*;
import java.util.Stack;

/* 
Максимальный байт
*/

public class Solution {
    private static String fileName;

    public static void main(String[] args) {
        readFileName();
        System.out.println(findMaxByteInFile(fileName));
    }

    public static void readFileName() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            fileName = reader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static int findMaxByteInFile(String fileName) {
        // find max byte in file
        int maxByte = Integer.MIN_VALUE;
        int readByte;
        try (FileInputStream inputStream = new FileInputStream(fileName)) {
            while (inputStream.available() > 0) {
                readByte = inputStream.read();
                if (readByte > maxByte) maxByte = readByte;
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return maxByte;
    }
}
