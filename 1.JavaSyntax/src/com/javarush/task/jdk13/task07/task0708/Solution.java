package com.javarush.task.jdk13.task07.task0708;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Самое большое число
*/

public class Solution {

    private static ArrayList<Integer> integers = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int count = 5;
        for (int i = 0; i < count; i++) {
            integers.add(Integer.parseInt(reader.readLine()));
        }
        int maxNumber = Integer.MIN_VALUE;
        for (int i = 0; i < integers.size(); i++) {
            if (integers.get(i) > maxNumber) maxNumber = integers.get(i);
        }

        System.out.println(maxNumber);
    }
}
