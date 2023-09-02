package com.javarush.task.task13.task1326;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/* 
Сортировка четных чисел из файла
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream inputStream = new FileInputStream(reader.readLine());
        ArrayList<Integer> list = new ArrayList<>();
        String number = "";
        while (inputStream.available() > 0) {
            char symbol = (char) (inputStream.read());
            if (symbol == '\n') {
                if (Integer.parseInt(number) % 2 == 0) list.add(Integer.parseInt(number));
                number = "";
            } else {
                number += symbol;
            }
        }
        if (Integer.parseInt(number) % 2 == 0) list.add(Integer.parseInt(number));

        reader.close();
        inputStream.close();

        Collections.sort(list);
        for (Integer integer : list) {
            System.out.println(integer);
        }
    }
}
