package com.javarush.task.jdk13.task09.task0930;

import java.util.ArrayList;
import java.util.Arrays;

public class ArraySorter {

    public void sort(String[] array) {
        for (int out = 0; out < array.length; out++) {
            for (int in = out + 1; in < array.length; in++) {
                if (isNumber(array[in]) && isNumber(array[out])) {
                    if (Integer.parseInt(array[in]) > Integer.parseInt(array[out])) {
                        String tmp = array[out];
                        array[out] = array[in];
                        array[in] = tmp;
                    }
                } else if (!isNumber(array[in]) && !isNumber(array[out])) {
                    if (isGreaterThan(array[out], array[in])) {
                        String tmp = array[out];
                        array[out] = array[in];
                        array[in] = tmp;
                    }
                }
            }
        }
    }

    // Метод для сравнения строк: 'а' больше чем 'b'
    public boolean isGreaterThan(String a, String b) {
        return a.compareTo(b) > 0;
    }


    // Переданная строка - это число?
    public boolean isNumber(String text) {
        if (text.length() == 0) {
            return false;
        }

        char[] chars = text.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char character = chars[i];
            if ((i != 0 && character == '-') // Строка содержит '-'
                    || (!Character.isDigit(character) && character != '-') // или не цифра и не начинается с '-'
                    || (chars.length == 1 && character == '-')) // или одиночный '-'
            {
                return false;
            }
        }
        return true;
    }
}
