package com.javarush.task.task18.task1807;

import java.io.*;

/* 
Подсчет запятых
*/

public class Solution {
    public static String fileName;

    public static void main(String[] args) {
        readFileName();
        System.out.println(countMatchesSymbolInFile(fileName, ','));
    }

    public static void readFileName() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            fileName = reader.readLine();
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }

    public static int countMatchesSymbolInFile(String fileName, char symbol) {
        int countMatches = 0;
        try (FileInputStream fileInputStream = new FileInputStream(fileName)) {
            while (fileInputStream.available() > 0) {
                if (fileInputStream.read() == symbol) countMatches++;
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return countMatches;
    }
}
