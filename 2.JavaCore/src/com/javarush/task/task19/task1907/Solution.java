package com.javarush.task.task19.task1907;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Считаем слово
*/

public class Solution {
    public static void main(String[] args) {
        String fileName = null;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            fileName = reader.readLine();
        } catch (IOException e) {
        }

        String fileContent = "";
        try (FileReader fileReader = new FileReader(fileName)) {
            while (fileReader.ready()) {
                fileContent += (char) fileReader.read();
            }
        } catch (IOException e) {
        }
        fileContent = fileContent.replaceAll("\\p{P}", ",").replaceAll("\\s", ",");
        int countWorld = 0;
        for (String s : fileContent.split(",")) {
            if (s.equals("world")) countWorld++;
        }
        System.out.println(countWorld);
    }
}
