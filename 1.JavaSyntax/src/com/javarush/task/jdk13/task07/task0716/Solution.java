package com.javarush.task.jdk13.task07.task0716;

import java.util.ArrayList;
import java.util.Arrays;

/* 
Р или Л
*/

public class Solution {
    public static void main(String[] args) {
        ArrayList<String> strings = new ArrayList<String>();
        strings.add("роза");
        strings.add("мера");
        strings.add("лоза");
        strings.add("лира");
        strings = fix(strings);

        for (String string : strings) {
            System.out.println(string);
        }
    }

    public static ArrayList<String> fix(ArrayList<String> strings) {
        ArrayList<String> result = new ArrayList<String>();
        for (String string : strings) {
            if (string.contains("р") && !string.contains("л")) continue;
            if (!string.contains("р") && string.contains("л")) result.add(string);
            result.add(string);
        }
        return result;
    }
}