package com.javarush.task.task34.task3403;

/* 
Разложение на множители с помощью рекурсии
*/

public class Solution {
    public void recurse(int n) {
        int i = 2;
        boolean isTrue = false;
        while (!isTrue) {
            if (n == 1) {
                isTrue = true;
            }
            if (n % i == 0) {
                System.out.print(i + " ");
                recurse(n / i);
                isTrue = true;
            }
            i++;
        }
    }

    public static void main(String[] args) {
        new Solution().recurse(132);
    }
}
