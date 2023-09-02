package com.javarush.task.task17.task1710;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/* 
CRUD
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    static SimpleDateFormat simpleDateFormatU = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
    static SimpleDateFormat simpleDateFormatR = new SimpleDateFormat("d-MMM-yyyy", Locale.ENGLISH);

    public static void main(String[] args) throws Exception {
        if (args == null || args.length < 2) throw new RuntimeException();
        Person person;

        switch (args[0]) {
            case "-c": {
                if (args[2].equals("м")) {
                    person = Person.createMale(args[1], simpleDateFormatU.parse(args[3]));
                } else {
                    person = Person.createFemale(args[1], simpleDateFormatU.parse(args[3]));
                }
                allPeople.add(person);
                System.out.println(allPeople.size() - 1);
                break;
            }
            case "-r": {
                person = allPeople.get(Integer.parseInt(args[1]));
                System.out.println(person.getName() + " " +
                        parseSex(String.valueOf(person.getSex())) + " " +
                        simpleDateFormatR.format(person.getBirthDate()));
                break;
            }
            case "-u": {
                switch (args[3]) {
                    case ("м"): {
                        allPeople.set(Integer.parseInt(args[1]), Person.createMale(args[2], simpleDateFormatU.parse(args[4])));
                        break;
                    }
                    case ("ж"): {
                        allPeople.set(Integer.parseInt(args[1]), Person.createFemale(args[2], simpleDateFormatU.parse(args[4])));
                        break;
                    }
                }
                break;
            }
            case "-d": {
                allPeople.get(Integer.parseInt(args[1])).setName(null);
                allPeople.get(Integer.parseInt(args[1])).setSex(null);
                allPeople.get(Integer.parseInt(args[1])).setBirthDate(null);
                break;
            }
        }
    }

    private static String parseSex(String sex) {
        if (sex.equals("MALE")) return "м";
        if (sex.equals("")) return "ж";
        else return null;
    }
}
