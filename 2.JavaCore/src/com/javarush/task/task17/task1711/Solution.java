package com.javarush.task.task17.task1711;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD 2
*/

public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createFemale("Петрова Ирина", new Date()));  //сегодня родился    id=1
    }

    static SimpleDateFormat simpleDateFormatOutput = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
    static SimpleDateFormat simpleDateFormatInput = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);

    public static void main(String[] args) throws Exception {
        if (args == null || args.length < 2) throw new RuntimeException();

        Person person;
        String name;
        String birthDay;
        Sex sex;

        switch (args[0]) {
            case ("-c"): {
                synchronized (allPeople) {
                    for (int i = 1; i < args.length; i += 3) {
                        name = args[i];
                        birthDay = args[i + 2];
                        if (args[i + 1].equals("м"))
                            allPeople.add(Person.createMale(name, simpleDateFormatInput.parse(birthDay)));
                        else if (args[i + 1].equals("ж")) {
                            allPeople.add(Person.createFemale(name, simpleDateFormatInput.parse(birthDay)));
                        }
                        System.out.println(allPeople.size() - 1);
                    }
                    break;
                }
            }
            case ("-u"): {
                synchronized (allPeople) {
                    for (int i = 1; i < args.length; i += 4) {
                        person = allPeople.get(Integer.parseInt(args[i]));
                        name = args[i + 1];
                        sex = args[i + 2].equals("м") ? Sex.MALE : Sex.FEMALE;
                        birthDay = args[i + 3];

                        person.setName(name);
                        person.setSex(sex);
                        person.setBirthDate(simpleDateFormatInput.parse(birthDay));
                    }
                    break;
                }
            }
            case ("-d"): {
                synchronized (allPeople) {
                    for (int i = 1; i < args.length; i++) {
                        person = allPeople.get(Integer.parseInt(args[i]));

                        person.setName(null);
                        person.setSex(null);
                        person.setBirthDate(null);
                    }
                    break;
                }
            }
            case ("-i"): {
                synchronized (allPeople) {
                    for (int i = 1; i < args.length; i++) {
                        person = allPeople.get(Integer.parseInt(args[i]));
                        name = person.getName();
                        char charSex = person.getSex().equals(Sex.MALE) ? 'м' : 'ж';
                        birthDay = simpleDateFormatOutput.format(person.getBirthDate());

                        System.out.println(name + " " + charSex + " " + birthDay);
                    }
                }
            }
        }
    }
}
