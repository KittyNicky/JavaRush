package com.javarush.task.jdk13.task02.task0217;

/* 
Минимум четырех чисел
*/

public class Solution {
    public static int min(int a, int b, int c, int d) {
        int minAB = min(a, b);
        int minCD = min(c, d);
        return min(minAB, minCD);

    }

    public static int min(int a, int b) {
        return a < b ? a : b;

    }

    public static void main(String[] args) {
        System.out.println(min(-20, -10));
        System.out.println(min(-40, -10, -30, 40));
        System.out.println(min(-20, -40, -30, 40));
        System.out.println(min(-20, -10, -40, 40));
        System.out.println(min(-20, -10, -30, -40));
    }
}
