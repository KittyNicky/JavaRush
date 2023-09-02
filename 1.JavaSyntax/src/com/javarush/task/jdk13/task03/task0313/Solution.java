package com.javarush.task.jdk13.task03.task0313;

/* 
Мама мыла раму
*/

public class Solution {
    public static void main(String[] args) {
        String[] words = new String[]{"Мама", "Мыла", "Раму"}; // 1 2 3 - 1 3 2 - 2 1 3 - 2 3 1 - 3 1 2 - 3 2 1
        String text = "%s%s%s";
        System.out.println(String.format(text, words[0], words[1], words[2]));
        System.out.println(String.format(text, words[0], words[2], words[1]));
        System.out.println(String.format(text, words[1], words[0], words[2]));
        System.out.println(String.format(text, words[1], words[2], words[0]));
        System.out.println(String.format(text, words[2], words[0], words[1]));
        System.out.println(String.format(text, words[2], words[1], words[0]));
    }
}
