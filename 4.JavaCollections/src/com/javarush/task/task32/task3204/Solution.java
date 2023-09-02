package com.javarush.task.task32.task3204;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.*;

/* 
Генератор паролей
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        ByteArrayOutputStream password = getPassword();
        System.out.println(password.toString());
    }

    public static ByteArrayOutputStream getPassword() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        List<Character> passwordChars = new ArrayList<>();
        int passwordLength = 8;
        while (passwordLength > 0) {
            passwordChars.add((char) ((int) (Math.random() * 26 + 97))); // lowerCase letter
            passwordChars.add((char) ((int) (Math.random() * 26 + 97))); // lowerCase letter
            passwordChars.add((char) ((int) (Math.random() * 26 + 65))); // upperCase letter
            passwordChars.add((char) ((int) (Math.random() * 10 + 48))); // numbers
            passwordLength -= 4;
        }
        Collections.shuffle(passwordChars);
        String result = "";
        for (Character passwordChar : passwordChars) {
            result += passwordChar;
        }
        try {
            outputStream.write(result.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return outputStream;
    }
}
