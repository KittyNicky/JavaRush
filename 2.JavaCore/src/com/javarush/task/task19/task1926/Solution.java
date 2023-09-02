package com.javarush.task.task19.task1926;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Перевертыши
*/

public class Solution {
    public static void main(String[] args) {
        String inputFile = null;
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            inputFile = bufferedReader.readLine();
        } catch (IOException e) {
        }

        try (BufferedReader inputFileReader = new BufferedReader(new FileReader(inputFile))) {
            String line;
            while ((line = inputFileReader.readLine()) != null) {
                for (int i = line.length() - 1; i >= 0; i--) {
                    System.out.print(line.charAt(i));
                }
                System.out.println();
            }
        } catch (IOException e) {
        }
    }
}
