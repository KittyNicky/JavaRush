package com.javarush.task.pro.task09.task0916;

/* 
String.format()
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(format("Амиго", 5000));
    }

    public static String format(String name, int salary) {
        String phrase = "Меня зовут %1$s. Я буду зарабатывать $%2$d в месяц.";
        return String.format(phrase, name, salary);
    }
}
