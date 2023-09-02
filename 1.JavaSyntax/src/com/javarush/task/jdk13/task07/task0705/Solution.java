package com.javarush.task.jdk13.task07.task0705;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Один большой массив и два маленьких
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] array1 = new int[20];
        int[] array2 = new int[10];
        int[] array3 = new int[10];

        for (int i = 0; i < array1.length; i++) {
            array1[i] = Integer.parseInt(reader.readLine());
        }

        for (int i = 0; i < array1.length; i++) {
            if (i < array1.length / 2) {
                array2[i] = array1[i];
            } else {
                array3[i%10] = array1[i];
            }
        }

        for (int value : array3) {
            System.out.println(value);
        }
    }
}
