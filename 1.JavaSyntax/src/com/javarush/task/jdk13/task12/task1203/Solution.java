package com.javarush.task.jdk13.task12.task1203;

/* 
Сознательный выбор
*/

public class Solution {

    public static void main(String[] args) {
        System.out.println(isByte(12)); // true
        System.out.println(isShort(130999)); // false
        System.out.println(isInt(1999939990L)); // true
        System.out.println(isInt(19999999939990L)); // false
    }

    public static boolean isByte(long l) {
        byte num = (byte) l;
        if (num == l) return true;
        else return false;
    }

    public static boolean isShort(long l) {
        short num = (short) l;
        if (num == l) return true;
        else return false;
    }

    public static boolean isInt(long l) {
        int num = (int) l;
        if (num == l) return true;
        else return false;
    }
}
