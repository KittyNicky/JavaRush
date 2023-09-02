package com.javarush.task.jdk13.task07.task0709;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Самая короткая строка
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        ArrayList<String> list = new ArrayList<String>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int count = 5;
        for (int i = 0; i < count; i++) {
            list.add(reader.readLine());
        }

        int minLenght = Integer.MAX_VALUE;
        for (int i = 0; i < list.size(); i++) {
            if ((list.get(i)).length() < minLenght) minLenght = (list.get(i)).length();
        }
        for (int i = 0; i < list.size(); i++) {
            if ((list.get(i)).length() == minLenght) System.out.println(list.get(i));
        }
    }
}
