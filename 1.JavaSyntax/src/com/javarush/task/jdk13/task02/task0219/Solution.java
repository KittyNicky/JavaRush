package com.javarush.task.jdk13.task02.task0219;

/* 
Вывод текста на экран
*/

public class Solution {
    public static void print3(String text) {
        int count = 3;
        for (int i = 0; i < count; i++) {
            System.out.print(text);
            if (i < count - 1)
                System.out.print(" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        print3("window");
        print3("file");
    }
}
