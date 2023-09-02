package com.javarush.task.jdk13.task08.task0816;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/* 
Удалить всех людей, родившихся летом
*/

public class Solution {
    public static Map<String, Date> createMap() throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat("MMMMM d yyyy", Locale.ENGLISH);
        Map<String, Date> map = new HashMap<>();
        map.put("Сталлоне1", dateFormat.parse("MAY 1 2012"));
        map.put("Сталлоне2", dateFormat.parse("JUNE 1 2012"));
        map.put("Сталлоне3", dateFormat.parse("JULY 1 2012"));
        map.put("Сталлоне4", dateFormat.parse("AUGUST 1 2012"));
        map.put("Сталлоне5", dateFormat.parse("JANUARY 1 2012"));
        map.put("Сталлоне6", dateFormat.parse("FEBRUARY 1 2012"));
        map.put("Сталлоне7", dateFormat.parse("MARCH 1 2012"));
        map.put("Сталлоне8", dateFormat.parse("APRIL 1 2012"));
        map.put("Сталлоне9", dateFormat.parse("OCTOBER 1 2012"));
        map.put("Сталлоне10", dateFormat.parse("SEPTEMBER 1 2012"));
        return map;
    }

    public static void removeAllSummerPeople(Map<String, Date> map) {
        Map<String, Date> copyMap = new HashMap<>(map);
        for (Map.Entry<String, Date> pair : copyMap.entrySet()) {
            Date date = map.get(pair.getKey());
            if (date.getMonth() > 4 && date.getMonth() < 8) map.remove(pair.getKey());
        }

    }

    public static void main(String[] args) throws ParseException {
    }
}
