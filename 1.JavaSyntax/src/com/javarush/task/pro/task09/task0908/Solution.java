package com.javarush.task.pro.task09.task0908;

/*
Двоично-шестнадцатеричный конвертер
*/

public class Solution {

    public static final String HEX = "0123456789abcdef";
    public static final String BINARY = "01";

    public static void main(String[] args) {
        String binaryNumber = "100111010000";
        System.out.println("Двоичное число " + binaryNumber + " равно шестнадцатеричному числу " + toHex(binaryNumber));
        String hexNumber = "9d0";
        System.out.println("Шестнадцатеричное число " + hexNumber + " равно двоичному числу " + toBinary(hexNumber));
    }

    public static String toHex(String binaryNumber) {
        if (!validateHex(binaryNumber)) return "";
        if (binaryNumber.length() % 4 != 0) binaryNumber = addZerosToBinary(binaryNumber);
        String hexNumber = convertBinaryToHex(binaryNumber);
        return hexNumber;
    }

    public static String toBinary(String hexNumber) {
        if (!validateBinary(hexNumber)) return "";
        String binaryNumber = convertHexToBinary(hexNumber);
        return binaryNumber;
    }

    public static boolean validateBinary(String hexNumber) {
        if (hexNumber == null || hexNumber.equals("")) return false;
        for (int i = 0; i < hexNumber.length(); i++) {
            char symbol = hexNumber.charAt(i);
            if (HEX.indexOf(symbol) == -1) return false;
        }
        return true;
    }

    public static boolean validateHex(String binaryNumber) {
        if (binaryNumber == null || binaryNumber.equals("")) return false;
        for (int i = 0; i < binaryNumber.length(); i++) {
            char symbol = binaryNumber.charAt(i);
            if (BINARY.indexOf(symbol) == -1) return false;
        }
        return true;
    }

    public static String addZerosToBinary(String binaryNumber) {
        int diff = 4 - binaryNumber.length() % 4;
        for (int i = 0; i < diff; i++) {
            binaryNumber = "0" + binaryNumber;
        }
        return binaryNumber;
    }

    public static String convertBinaryToHex(String binaryNumber) {
        String hexNumber = "";
        for (int i = 0; i < binaryNumber.length(); i += 4) {
            String subString = binaryNumber.substring(i, i + 4);
            if (subString.equals("0000")) hexNumber += "0";
            else if (subString.equals("0001")) hexNumber += "1";
            else if (subString.equals("0010")) hexNumber += "2";
            else if (subString.equals("0011")) hexNumber += "3";
            else if (subString.equals("0100")) hexNumber += "4";
            else if (subString.equals("0101")) hexNumber += "5";
            else if (subString.equals("0110")) hexNumber += "6";
            else if (subString.equals("0111")) hexNumber += "7";
            else if (subString.equals("1000")) hexNumber += "8";
            else if (subString.equals("1001")) hexNumber += "9";
            else if (subString.equals("1010")) hexNumber += "a";
            else if (subString.equals("1011")) hexNumber += "b";
            else if (subString.equals("1100")) hexNumber += "c";
            else if (subString.equals("1101")) hexNumber += "d";
            else if (subString.equals("1110")) hexNumber += "e";
            else if (subString.equals("1111")) hexNumber += "f";
        }
        return hexNumber;
    }

    public static String convertHexToBinary(String hexNumber) {
        String binaryNumber = "";
        for (int i = 0; i < hexNumber.length(); i++) {
            String subString = String.valueOf(hexNumber.charAt(i));
            if (subString.equals("0")) binaryNumber += "0000";
            else if (subString.equals("1")) binaryNumber += "0001";
            else if (subString.equals("2")) binaryNumber += "0010";
            else if (subString.equals("3")) binaryNumber += "0011";
            else if (subString.equals("4")) binaryNumber += "0100";
            else if (subString.equals("5")) binaryNumber += "0101";
            else if (subString.equals("6")) binaryNumber += "0110";
            else if (subString.equals("7")) binaryNumber += "0111";
            else if (subString.equals("8")) binaryNumber += "1000";
            else if (subString.equals("9")) binaryNumber += "1001";
            else if (subString.equals("a")) binaryNumber += "1010";
            else if (subString.equals("b")) binaryNumber += "1011";
            else if (subString.equals("c")) binaryNumber += "1100";
            else if (subString.equals("d")) binaryNumber += "1101";
            else if (subString.equals("e")) binaryNumber += "1110";
            else if (subString.equals("f")) binaryNumber += "1111";
        }
        return binaryNumber;
    }
}