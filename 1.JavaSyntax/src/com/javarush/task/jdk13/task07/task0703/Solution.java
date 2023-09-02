package com.javarush.task.jdk13.task07.task0703;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Два массива
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] ints = new int[10];
        String[] strings = new String[10];

        for (int i = 0; i < strings.length; i++) {
            strings[i] = reader.readLine();
        }

        for (int i = 0; i < ints.length; i++) {
            ints[i] = strings[i].length();
        }

        for (int value : ints) {
            System.out.println(value);
        }
    }
}
