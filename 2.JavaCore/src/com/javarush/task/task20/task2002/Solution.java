package com.javarush.task.task20.task2002;

import java.io.*;
import java.util.*;

/* 
Читаем и пишем в файл: JavaRush
*/

public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or adjust outputStream/inputStream according to your file's actual location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            //File yourFile = File.createTempFile("/Users/nikita.z/myJava/ideaProject/docs/tmp.txt", null);
            String yourFile = "/Users/nikita.z/myJava/ideaProject/docs/1.txt";
            OutputStream outputStream = new FileOutputStream(yourFile);
            InputStream inputStream = new FileInputStream(yourFile);

            JavaRush javaRush = new JavaRush();
            User javaRushUser1 = new User();
            Date birthday1 = new GregorianCalendar(2000, 10 - 1, 10).getTime();
            javaRushUser1.setFirstName("javaRushFirstName");
            javaRushUser1.setLastName("javaRushLastName");
            javaRushUser1.setMale(true);
            javaRushUser1.setBirthDate(birthday1);
            javaRushUser1.setCountry(User.Country.RUSSIA);
            javaRush.users.add(javaRushUser1);
            User javaRushUser2 = new User();
            Date birthday2 = new GregorianCalendar(2000, 10 - 1, 10).getTime();
            javaRushUser2.setFirstName("javaRushFirstName2");
            javaRushUser2.setLastName("javaRushLastName2");
            javaRushUser2.setMale(false);
            javaRushUser2.setBirthDate(birthday2);
            javaRushUser2.setCountry(User.Country.UKRAINE);
            javaRush.users.add(javaRushUser2);
            for (User user : javaRush.users) {
                System.out.println(user.getFirstName());
            }
            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут
            javaRush.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            //here check that the javaRush object is equal to the loadedObject object - проверьте тут, что javaRush и loadedObject равны
            System.out.println(javaRushUser1.equals(loadedObject));

            for (User user : loadedObject.users) {
                System.out.println(user.getFirstName());
            }
            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something is wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something is wrong with the save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
            PrintWriter printWriter = new PrintWriter(outputStream);
            for (User user : users) {
                printWriter.println(user.getFirstName());
                printWriter.println(user.getLastName());
                printWriter.println(user.isMale());
                printWriter.println(user.getBirthDate().getTime());
                printWriter.println(user.getCountry());
            }
            printWriter.close();
        }

        public void load(InputStream inputStream) throws Exception {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            try {
                while (bufferedReader.ready()) {
                    User user = new User();
                    user.setFirstName(bufferedReader.readLine());
                    user.setLastName(bufferedReader.readLine());
                    user.setMale(Boolean.parseBoolean(bufferedReader.readLine()));
                    user.setBirthDate(new Date(Long.parseLong(bufferedReader.readLine())));
                    String country = bufferedReader.readLine();
                    switch (country) {
                        case ("RUSSIA"): {
                            user.setCountry(User.Country.RUSSIA);
                            break;
                        }
                        case ("UKRAINE"): {
                            user.setCountry(User.Country.UKRAINE);
                            break;
                        }
                        case ("OTHER"): {
                            user.setCountry(User.Country.OTHER);
                            break;
                        }
                    }
                    users.add(user);
                }
            } catch (Exception e) {
                System.out.println("Пустых полей у объекта User быть не может.");
            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            JavaRush javaRush = (JavaRush) o;

            return users != null ? users.equals(javaRush.users) : javaRush.users == null;

        }

        @Override
        public int hashCode() {
            return users != null ? users.hashCode() : 0;
        }
    }
}
