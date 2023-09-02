package com.javarush.task.task18.task1816;

import java.io.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/* 
Английские буквы
*/

public class Solution {
    public static void main(String[] args) {
        if (args.length == 0) return;
        String fileName = args[0];
        int countEnglishLaters = 0;
        int c;
        try (FileInputStream fileInputStream = new FileInputStream(fileName)) {
            while (fileInputStream.available() > 0) {
                c = fileInputStream.read();
                if (c >= 65 && c <= 122) ++countEnglishLaters;
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println(countEnglishLaters);
    }
}
