package com.javarush.task.task19.task1921;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/* 
Хуан Хуанович
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) {
        if (args.length == 0) return;

        String fileName = args[0];
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            String[] line = null;
            int lineLength = 0;
            while (bufferedReader.ready()) {
                line = bufferedReader.readLine().split(" ");
                lineLength = line.length;
                int year = Integer.parseInt(line[lineLength - 1]);
                int month = Integer.parseInt(line[lineLength - 2]) - 1;
                int day = Integer.parseInt(line[lineLength - 3]);
                Date birthDate = new GregorianCalendar(year, month, day).getTime();
                String name = "";
                for (int i = 0; i < lineLength - 3; i++) {
                    name += line[i] + " ";
                }
                name = name.trim();
                PEOPLE.add(new Person(name, birthDate));
            }
        } catch (IOException e) {
        }
    }
}
