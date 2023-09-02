package com.javarush.task.task18.task1803;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* 
Самые частые байты
*/

public class Solution {
    private static String fileName;

    public static void main(String[] args) throws Exception {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            fileName = reader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        findMaxRepeatByte(fileName);
    }

    private static void findMaxRepeatByte(String fileName) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int readByte;
        try (FileInputStream inputStream = new FileInputStream(fileName)) {
            while (inputStream.available() > 0) {
                readByte = inputStream.read();
                if (!map.containsKey(readByte)) map.put(readByte, 1);
                else map.replace(readByte, map.get(readByte) + 1);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        int maxRepsValue = Integer.MIN_VALUE;
        for (Map.Entry<Integer, Integer> item : map.entrySet()) {
            int value = item.getValue();
            if (value > maxRepsValue) maxRepsValue = value;
        }

        ArrayList<Integer> list = new ArrayList<Integer>();
        for (Integer key : map.keySet()) {
            if (map.get(key).equals(maxRepsValue)) list.add(key);
        }
        for (Integer integer : list) {
            System.out.print(integer + " ");
        }
    }
}
