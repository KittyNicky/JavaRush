package com.javarush.task.jdk13.task09.task0923;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Гласные и согласные буквы
*/

public class Solution {
    public static char[] vowels = new char[]{'а', 'я', 'у', 'ю', 'и', 'ы', 'э', 'е', 'о', 'ё'};

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String text = reader.readLine();
        String vowelString = "";
        String consonantsString = "";
        for (int i = 0; i < text.length(); i++) {
            if (isVowel(text.charAt(i))) vowelString += text.charAt(i) + " ";
            else if (text.charAt(i) != ' ') consonantsString += text.charAt(i) + " ";
        }
        System.out.println(vowelString);
        System.out.println(consonantsString);

    }

    // метод проверяет, гласная ли буква
    public static boolean isVowel(char character) {
        character = Character.toLowerCase(character);  // приводим символ в нижний регистр - от заглавных к строчным буквам
        for (char vowel : vowels) {  // ищем среди массива гласных
            if (character == vowel) {
                return true;
            }
        }
        return false;
    }
}