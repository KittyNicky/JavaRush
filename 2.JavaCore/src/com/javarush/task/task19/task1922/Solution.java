package com.javarush.task.task19.task1922;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Ищем нужные строки
*/

public class Solution {
    public static List<String> words = new ArrayList<String>();

    static {
        words.add("файл");
        words.add("вид");
        words.add("В");
    }

    public static void main(String[] args) {

        // read file name
        String fileName = null;
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            fileName = bufferedReader.readLine();
        } catch (IOException e) {
        }

        // read file and print line with 2 contains in list "words"
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            while (bufferedReader.ready()) {
                int countContains = 0;
                String line = bufferedReader.readLine();
                for (String s : line.split(" ")) {
                    if (words.contains(s)) countContains++;
                }
                if (countContains == 2) System.out.println(line);
            }
        } catch (IOException e) {
        }

    }
}
