package com.javarush.task.jdk13.task12.task1205;

/* 
А мне так нужно
*/

public class Solution {

    private static String UNEXPECTED_TYPE = "Я такого типа числа не жду!";

    public static void main(String[] args) {
        System.out.println(toCustomString((byte) 12));
        System.out.println(toCustomString(12));
        System.out.println(toCustomString(12.));
        System.out.println(toCustomString(12L));
    }

    public static String toCustomString(Number number) {
        if (number instanceof Byte) {
            number = (byte) number / 2;
            return String.valueOf(number) + "b";
        } else if (number instanceof Integer) {
            number = (Integer) number / 3;
            return String.valueOf(number);
        } else if (number instanceof Double) {
            number = (Double) number * 20;
            return String.valueOf(number);
        } else
            return "Я такого типа числа не жду!";
    }
}
