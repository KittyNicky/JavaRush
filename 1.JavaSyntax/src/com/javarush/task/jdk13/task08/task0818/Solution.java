package com.javarush.task.jdk13.task08.task0818;

import java.util.HashMap;
import java.util.Map;

/* 
Налоговая и зарплаты
*/

public class Solution {
    public static Map<String, Integer> createMap() {
        Map<String, Integer> map = new HashMap<>();
        map.put("secondName1", 495);
        map.put("secondName2", 496);
        map.put("secondName3", 497);
        map.put("secondName4", 498);
        map.put("secondName5", 499);
        map.put("secondName6", 500);
        map.put("secondName7", 501);
        map.put("secondName8", 502);
        map.put("secondName9", 503);
        map.put("secondName10", 504);
        return map;
    }

    public static void removeItemFromMap(Map<String, Integer> map) {
        Map<String, Integer> copyMapy = new HashMap<>(map);
        for (Map.Entry<String, Integer> pair : copyMapy.entrySet()) {
            String key = pair.getKey();
            int value = map.get(pair.getKey());
            if (value < 500) map.remove(key);
        }
    }

    public static void main(String[] args) {
    }
}