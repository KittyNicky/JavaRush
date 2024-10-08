package com.javarush.task.task33.task3310.tests;

import com.javarush.task.task33.task3310.Helper;
import com.javarush.task.task33.task3310.Shortener;
import com.javarush.task.task33.task3310.strategy.HashBiMapStorageStrategy;
import com.javarush.task.task33.task3310.strategy.HashMapStorageStrategy;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class SpeedTest {
    public long getTimeToGetIds(Shortener shortener, Set<String> strings, Set<Long> ids) {
        Date start = new Date();
        for (String string : strings) {
            ids.add(shortener.getId(string));
        }
        Date end = new Date();

        return end.getTime() - start.getTime();
    }

    public long getTimeToGetStrings(Shortener shortener, Set<Long> ids, Set<String> strings) {
        Date start = new Date();
        for (Long id : ids) {
            strings.add(shortener.getString(id));
        }
        Date end = new Date();

        return end.getTime() - start.getTime();
    }

    @Test
    public void testHashMapStorage() {
        Shortener shortener1 = new Shortener(new HashMapStorageStrategy());
        Shortener shortener2 = new Shortener(new HashBiMapStorageStrategy());

        int elementsNumber = 10000;
        Set<String> origStrings = new HashSet<>();
        Set<Long> ids = new HashSet<>();
        for (int i = 0; i < elementsNumber; i++) {
            origStrings.add(Helper.generateRandomString());
        }


        Long timeToGetIdsShortener1 = getTimeToGetIds(shortener1, origStrings, new HashSet<Long>());
        Long timeToGetIdsShortener2 = getTimeToGetIds(shortener2, origStrings, new HashSet<Long>());
        Assert.assertTrue(timeToGetIdsShortener1 > timeToGetIdsShortener2);

        Long timeToGetStringsShortener1 = getTimeToGetStrings(shortener1, new HashSet<Long>(), origStrings);
        Long timeToGetStringsShortener2 = getTimeToGetStrings(shortener2, new HashSet<Long>(), origStrings);
        Assert.assertEquals(timeToGetStringsShortener1, timeToGetStringsShortener2, 30);


    }
}
