package com.javarush.task.task19.task1925;

import java.io.*;
import java.util.ArrayList;

/* 
Длинные слова
*/

public class Solution {
    public static void main(String[] args) {
        if (args.length != 2) return;
        String inputFile = args[0];
        String outputFile = args[1];
        String writeLine = "";

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(inputFile))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                for (String s : line.split(" ")) {
                    if (s.length() > 6) writeLine += s + ",";
                }
            }
        } catch (IOException e) {
        }

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(outputFile))) {
            bufferedWriter.write(writeLine.substring(0, writeLine.length() - 1));
        } catch (IOException e) {
        }
    }
}
