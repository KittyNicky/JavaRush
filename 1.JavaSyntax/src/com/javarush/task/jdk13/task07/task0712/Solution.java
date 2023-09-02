package com.javarush.task.jdk13.task07.task0712;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Минимальное или максимальное
*/

public class Solution {

    public static ArrayList<String> strings;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        strings = new ArrayList<String>();
        for (int i = 0; i < 10; i++) {
            strings.add(reader.readLine());
        }

        int indexMaxValue = 0, indexMinValue = 0;
        int maxValueLength = Integer.MAX_VALUE, minValueLength = Integer.MIN_VALUE;
        int lenValueFromStrings = 0;

        for (int i = 0; i < strings.size(); i++) {
            lenValueFromStrings = (strings.get(i)).length();
            if (lenValueFromStrings > minValueLength) {
                indexMaxValue = i;
                minValueLength = lenValueFromStrings;
            }
            if (lenValueFromStrings < maxValueLength) {
                indexMinValue = i;
                maxValueLength = lenValueFromStrings;
            }
        }
        if (indexMinValue < indexMaxValue) System.out.println(strings.get(indexMinValue));
        else System.out.println(strings.get(indexMaxValue));
    }
}
