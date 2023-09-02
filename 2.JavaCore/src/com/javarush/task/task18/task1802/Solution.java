package com.javarush.task.task18.task1802;

import java.io.*;

/* 
Минимальный байт
*/

public class Solution {
    private static String fileName;

    static {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            fileName = reader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println(findMinByteInFile(fileName));
    }

    private static int findMinByteInFile(String fileName) {
        int minByte = Integer.MAX_VALUE;
        int readByte;
        try (FileInputStream inputStream = new FileInputStream(fileName)) {
            while (inputStream.available() > 0) {
                readByte = inputStream.read();
                if (readByte < minByte) minByte = readByte;
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return minByte;
    }
}

