package com.javarush.task.jdk13.task08.task0817;

import java.util.HashMap;
import java.util.Map;

/* 
Удалить людей, имеющих одинаковые имена
*/

public class Solution {
    public static Map<String, String> createMap() {
        Map<String, String> map = new HashMap<>();
        map.put("firstName1", "secondName1");
        map.put("firstName2", "secondName2");
        map.put("firstName3", "secondName2");
        map.put("firstName4", "secondName3");
        map.put("firstName5", "secondName3");
        map.put("firstName6", "secondName3");
        map.put("firstName7", "secondName4");
        map.put("firstName8", "secondName4");
        map.put("firstName9", "secondName4");
        map.put("firstName10", "secondName4");
        return map;

    }

    public static void removeTheFirstNameDuplicates(Map<String, String> map) {
        Map<String, String> copyMap = new HashMap<>(map);
        for (String copyValue : copyMap.values()) {
            int count = 0;
            for (String mapValue : map.values()) {
                if (mapValue.equals(copyValue)) count++;
            }
            if (count > 1) removeItemFromMapByValue(map, copyValue);
        }

    }

    public static void removeItemFromMapByValue(Map<String, String> map, String value) {
        Map<String, String> copy = new HashMap<>(map);
        for (Map.Entry<String, String> pair : copy.entrySet()) {
            if (pair.getValue().equals(value)) {
                map.remove(pair.getKey());
            }
        }
    }

    public static void main(String[] args) {
//        Map<String, String> map = createMap();
//        System.out.println(map.values());
//        removeTheFirstNameDuplicates(map);
//        System.out.println(map.values());

    }
}
