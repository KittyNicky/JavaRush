package com.javarush.task.task19.task1924;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* 
Замена чисел
*/

public class Solution {
    public static Map<Integer, String> map = new HashMap<Integer, String>();

    static {
        map.put(0, "ноль");
        map.put(1, "один");
        map.put(2, "два");
        map.put(3, "три");
        map.put(4, "четыре");
        map.put(5, "пять");
        map.put(6, "шесть");
        map.put(7, "семь");
        map.put(8, "восемь");
        map.put(9, "девять");
        map.put(10, "десять");
        map.put(11, "одиннадцать");
        map.put(12, "двенадцать");
    }

    public static void main(String[] args) {
        String inputFileName = "/Users/nikita.z/myJava/ideaProject/docs/1.txt";//null;
//        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
//            inputFileName = bufferedReader.readLine();
//        } catch (IOException e) {
//        }

        try (BufferedReader inputFileReader = new BufferedReader(new FileReader(inputFileName))) {
            String fileReadLine;
            while ((fileReadLine = inputFileReader.readLine()) != null) {
                for (Map.Entry<Integer, String> item : map.entrySet()) {
                    fileReadLine = fileReadLine.replaceAll("\\b" + item.getKey() + "\\b", item.getValue());
                }
                System.out.println(fileReadLine);
            }
        } catch (IOException e) {
        }
    }
}
