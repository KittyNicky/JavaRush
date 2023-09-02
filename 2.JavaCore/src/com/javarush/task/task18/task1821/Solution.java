package com.javarush.task.task18.task1821;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/* 
Встречаемость символов
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        if (args.length == 0) return;

        Map<Integer, Integer> map = new HashMap<>();
        try (FileInputStream fileInputStream = new FileInputStream(args[0])) {
            while (fileInputStream.available() > 0) {
                int c = fileInputStream.read();
                if (map.containsKey(c)) map.put(c, map.get(c) + 1);
                else map.put(c, 1);
            }
        }

        List<Integer> list = new ArrayList<>(map.keySet());
        Collections.sort(list);

        for (Integer integer : list) {
            System.out.println((char) ((int) integer) + " " + map.get(integer));
        }
    }
}
