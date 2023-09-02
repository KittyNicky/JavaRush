package com.javarush.task.jdk13.task07.task0718;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Сортировка списка
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> words = new ArrayList<String>();

        for (int i = 0; i < 10; i++) {
            words.add(reader.readLine());
        }

        int minLength = Integer.MIN_VALUE;

        for (int i = 0; i < words.size(); i++) {
            if ((words.get(i)).length() > minLength) minLength = (words.get(i)).length();
            else {
                System.out.println(i);
                break;
            }
        }


    }
}

