package com.javarush.task.jdk13.task08.task0821;

import java.util.HashMap;
import java.util.Map;

/* 
Однофамильцы и тёзки
*/

public class Solution {
    public static void main(String[] args) {
        Map<String, String> map = createPeopleMap();
        printPeopleMap(map);
    }

    public static Map<String, String> createPeopleMap() {
        Map<String, String> map = new HashMap<>();
        map.put("a1", "1");
        map.put("a1", "2");
        map.put("b1", "1");
        map.put("b1", "2");
        map.put("c1", "1");
        map.put("c1", "2");
        map.put("d1", "3");
        map.put("d1", "4");
        map.put("e1", "3");
        map.put("e2", "4");

        return map;
    }

    public static void printPeopleMap(Map<String, String> map) {
        for (Map.Entry<String, String> s : map.entrySet()) {
            System.out.println(s.getKey() + " " + s.getValue());
        }
    }
}
