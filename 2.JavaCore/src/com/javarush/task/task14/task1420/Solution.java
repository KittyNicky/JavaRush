package com.javarush.task.task14.task1420;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
НОД
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(reader.readLine());
        int b = Integer.parseInt(reader.readLine());

        System.out.println(findNOD(a, b));
    }

    public static int findMin(int a, int b) {
        return a < b ? a : b;
    }

    public static int findNOD(int a, int b) {
        int NOD = 1;
        for (int i = NOD; i <= findMin(a, b); i++) {
            if (a % i == 0 && b % i == 0) NOD = i;
        }
        return NOD;
    }
}
