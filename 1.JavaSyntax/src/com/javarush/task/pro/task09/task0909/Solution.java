package com.javarush.task.pro.task09.task0909;

/* 
Экранирование символов
*/

public class Solution {
    public static void main(String[] args) {
        String s1 = "It's a Windows path: \"C:\\Program Files\\Java\\jdk-13.0.0\\bin\"";
        String s2 = "It's a Java string: \\\"C:\\\\Program Files\\\\Java\\\\jdk-13.0.0\\\\bin\\\"";
        System.out.println(s1);
        System.out.println(s2);
    }
}
