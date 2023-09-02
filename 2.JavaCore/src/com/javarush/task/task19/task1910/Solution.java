package com.javarush.task.task19.task1910;

import java.io.*;
import java.util.ArrayList;

/*
Пунктуация
*/

public class Solution {
    public static void main(String[] args) {
        String fileNameReader = null;
        String fileNameWriter = null;
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            fileNameReader = bufferedReader.readLine();
            fileNameWriter = bufferedReader.readLine();
        } catch (IOException e) {
        }

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileNameReader));
             BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileNameWriter))) {
            while (bufferedReader.ready()) {
                String line = bufferedReader.readLine().replaceAll("\\p{P}", "");
                bufferedWriter.write(line);
            }
        } catch (IOException e) {
        }
    }
}
