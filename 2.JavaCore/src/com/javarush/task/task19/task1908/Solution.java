package com.javarush.task.task19.task1908;

import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

/* 
Выделяем числа
*/

public class Solution {
    public static void main(String[] args) {
        String fileNameReader = null;
        String fileNameWriter = null;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            fileNameReader = reader.readLine();
            fileNameWriter = reader.readLine();
        } catch (IOException e) {
        }

        String fileReaderContent = "";
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileNameReader))) {
            while (bufferedReader.ready()) {
                fileReaderContent += bufferedReader.readLine();
            }
        } catch (IOException e) {
        }

        fileReaderContent = fileReaderContent.replaceAll("\\p{P}", ",").replaceAll("\\s", ",");
        System.out.println(fileReaderContent);
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileNameWriter))) {
            for (String s : fileReaderContent.split(",")) {
                try {
                    bufferedWriter.write(Integer.parseInt(s) + " ");
                } catch (NumberFormatException e) {
                }
            }
        } catch (IOException e) {
        }
    }
}
