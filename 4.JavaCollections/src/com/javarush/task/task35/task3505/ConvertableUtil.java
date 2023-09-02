package com.javarush.task.task35.task3505;

import java.security.Key;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConvertableUtil {
    public static <T extends Convertable> Map convert(List<T> list) {
        Map map = new HashMap();
        for (T value : list) {
            map.put(value.getKey(), value);
        }
        return map;
    }
}
