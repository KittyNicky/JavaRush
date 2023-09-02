package com.javarush.task.task19.task1919;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/* 
Считаем зарплаты
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
                if (salary.containsKey(surname)) salary.replace(surname, salary.get(surname) + value);
                else salary.put(surname, value);
            }
        } catch (IOException e) {
        }

        // sort keys in salary map
        List<String> surnames = new ArrayList<>(salary.keySet());
        Collections.sort(surnames);

        // print
        for (String surname : surnames) {
            System.out.println(surname + " " + salary.get(surname));
        }
    }
}
