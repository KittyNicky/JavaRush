package com.javarush.task.task33.task3310;

import com.javarush.task.task33.task3310.strategy.*;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        long elementsNumber = 20000;

        testStrategy(new HashMapStorageStrategy(), elementsNumber);
        testStrategy(new OurHashMapStorageStrategy(), elementsNumber);
        //testStrategy(new FileStorageStrategy(), elementsNumber);
        testStrategy(new OurHashBiMapStorageStrategy(), elementsNumber);
        testStrategy(new HashBiMapStorageStrategy(), elementsNumber);
        testStrategy(new DualHashBidiMapStorageStrategy(), elementsNumber);
    }

    public static Set<Long> getIds(Shortener shortener, Set<String> strings) {
        Set keys = new HashSet();
        for (String value : strings) {
            keys.add(shortener.getId(value));
        }
        return keys;
    }

    public static Set<String> getStrings(Shortener shortener, Set<Long> keys) {
        Set values = new HashSet();
        for (Long key : keys) {
            values.add(shortener.getString(key));
        }
        return values;
    }

    public static void testStrategy(StorageStrategy strategy, long elementsNumber) {
        Helper.printMessage(strategy.getClass().getSimpleName());
        Set<String> set = new HashSet<>();

        for (long i = 0; i < elementsNumber; i++) {
            set.add(Helper.generateRandomString());
        }
        Shortener shortener = new Shortener(strategy);

        Date startDate = new Date();
        Set<Long> keys = getIds(shortener, set);
        Date endDate = new Date();
        Long diffDates = (Long) (endDate.getTime() - startDate.getTime());
        Helper.printMessage("Время (мс) получения идентификаторов для " + elementsNumber + " элементов: " + diffDates);

        startDate = new Date();
        Set<String> values = getStrings(shortener, keys);
        endDate = new Date();
        diffDates = (Long) (endDate.getTime() - startDate.getTime());
        Helper.printMessage("Время (мс) получения строк для " + elementsNumber + " элементов: " + diffDates);

        if (set.equals(values)) Helper.printMessage("Тест пройден.");
        else Helper.printMessage("Тест не пройден.");
    }
}
