package com.javarush.task.task19.task1923;

import java.io.*;

/* 
Слова с цифрами
*/

public class Solution {
    public static void main(String[] args) {
        if (args.length != 2) return;
        String fileNameInput = args[0];
        String fileNameOutput = args[1];

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileNameInput));
             BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileNameOutput))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                boolean hasDigits = false;
                for (String s : line.split(" ")) {
                    for (int i = 0; i < s.length() && !hasDigits; i++) {
                        if (Character.isDigit(s.charAt(i))) {
                            hasDigits = true;
                            bufferedWriter.write(s + " ");
                        }
                    }
                }
            }
        } catch (IOException e) {
        }
    }
}
