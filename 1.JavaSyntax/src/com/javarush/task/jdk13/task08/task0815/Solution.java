package com.javarush.task.jdk13.task08.task0815;

import java.util.HashMap;
import java.util.Map;

/* 
Одинаковые имя и фамилия
*/

public class Solution {
    public static Map<String, String> createMap() {
        Map<String, String> map = new HashMap<String, String>();
        map.put("firstName1", "secondName1");
        map.put("firstName2", "secondName2");
        map.put("firstName3", "secondName3");
        map.put("firstName4", "secondName3");
        map.put("firstName5", "secondName3");
        map.put("firstName6", "secondName4");
        map.put("firstName7", "secondName5");
        map.put("firstName8", "secondName5");
        map.put("firstName9", "secondName5");
        map.put("firstName10", "secondName5");
        return map;
    }

    public static int getCountTheSameFirstName(Map<String, String> map, String name) {
        int countTheSame = 0;
        for (Map.Entry<String, String> pair : map.entrySet()) {
            if (pair.getValue().equals(name)) countTheSame += 1;
        }
        return countTheSame;
    }

    public static int getCountTheSameLastName(Map<String, String> map, String lastName) {
        int countTheSame = 0;
        for (Map.Entry<String, String> pair : map.entrySet()) {
            if (pair.getKey().equals(lastName)) countTheSame += 1;
        }
        return countTheSame;

    }

    public static void main(String[] args) {
    }
}
