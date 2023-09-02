package com.javarush.task.task36.task3605;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.TreeSet;

/* 
Использование TreeSet
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        if (args.length != 1) return;

        TreeSet<Character> set = new TreeSet<>();
        String file = args[0];

        try (BufferedReader inputStream = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = inputStream.readLine()) != null) {
                for (char c : line.toCharArray()) {
                    if (c >= 97 & c < 123)
                        set.add(c);
                }
            }
        }

        int size = 5;
        for (Character c : set) {
            System.out.print(c);
            size--;
            if (size == 0) break;
        }

    }
}
