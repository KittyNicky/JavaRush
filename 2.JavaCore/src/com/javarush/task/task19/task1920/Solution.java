package com.javarush.task.task19.task1920;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/* 
Самый богатый
*/

public class Solution {
    public static void main(String[] args) {
        if (args.length == 0) return;

        String fileName = args[0];
        Map<String, Double> salary = new HashMap<>();

        // read file and put key-value in Map
        try (BufferedReader fileReader = new BufferedReader(new FileReader(fileName))) {
            while (fileReader.ready()) {
                String[] line = fileReader.readLine().split(" ");
                String surname = line[0];
                Double value = Double.parseDouble(line[1]);
                if (salary.containsKey(surname)) salary.put(surname, salary.get(surname) + value);
                else salary.put(surname, value);
            }
        } catch (IOException e) {
        }

        // find surnames with max salary
        double maxSalary = Double.MIN_VALUE;
        Set<String> surnamesWithMaxSalary = new HashSet<>();
        for (Map.Entry<String, Double> item : salary.entrySet()) {
            if (item.getValue() >= maxSalary) {
                maxSalary = item.getValue();
                surnamesWithMaxSalary.add(item.getKey());
            }
        }
        for (String s : surnamesWithMaxSalary) {
            System.out.println(s);
        }
    }
}
