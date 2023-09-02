package com.javarush.task.task18.task1804;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/*
Самые редкие байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        String fileName;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            fileName = reader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        findMinRepeatByte(fileName);
    }

    private static void findMinRepeatByte(String fileName) {
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

        int minRepsValue = Integer.MAX_VALUE;
        for (Map.Entry<Integer, Integer> item : map.entrySet()) {
            int value = item.getValue();
            if (value < minRepsValue) minRepsValue = value;
        }

        ArrayList<Integer> list = new ArrayList<Integer>();
        for (Integer key : map.keySet()) {
            if (map.get(key).equals(minRepsValue)) list.add(key);
        }
        for (Integer integer : list) {
            System.out.print(integer + " ");
        }
    }
}
