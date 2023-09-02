package com.javarush.task.task37.task3714;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/* 
Древний Рим
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Input a roman number to be converted to decimal: ");
        String romanString = bufferedReader.readLine();
        System.out.println("Conversion result equals " + romanToInteger(romanString));
    }

    private static int romanToNumber(char c) {
        switch (c) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                throw new NumberFormatException("Invalid format");
        }
    }

    public static int romanToInteger(String s) {
        int result = 0;
        int previousNumber = romanToNumber(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            int currentNumber = romanToNumber(s.charAt(i));
            if (currentNumber <= previousNumber) result += previousNumber;
            else result -= previousNumber;
            previousNumber = currentNumber;
        }
        result += previousNumber;
        return result;
    }
}
