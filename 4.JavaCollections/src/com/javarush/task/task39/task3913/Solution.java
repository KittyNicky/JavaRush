package com.javarush.task.task39.task3913;

import java.nio.file.Paths;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Set;

public class Solution {
    public static void main(String[] args) throws ParseException {
        LogParser logParser = new LogParser(Paths.get("/Users/nikita.z/myJava/ideaProject/JavaRushTasks/4.JavaCollections/src/com/javarush/task/task39/task3913/logs/"));
        System.out.println(logParser.getNumberOfUniqueIPs(null, new Date()));
        Set<Object> ips = logParser.execute("get ip for user = \"Eduard Petrovich Morozko\" and date between \"11.12.2013 0:00:00\" and \"03.01.2014 23:59:59\"");
        System.out.println(Arrays.toString(new Set[]{ips}));
    }
}