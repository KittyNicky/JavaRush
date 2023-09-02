package com.javarush.task.task19.task1904;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

/* 
И еще один адаптер
*/

public class Solution {

    public static void main(String[] args) {

    }

    public static class PersonScannerAdapter implements PersonScanner {
        private Scanner fileScanner;

        public PersonScannerAdapter(Scanner fileScanner) {
            this.fileScanner = fileScanner;
        }

        @Override
        public Person read() throws IOException {
            String[] line = this.fileScanner.nextLine().split(" ");
            String firstName = line[1];
            String middleName = line[2];
            String lastName = line[0];
            Calendar calendar = new GregorianCalendar(
                    Integer.parseInt(line[5]),
                    Integer.parseInt(line[4]) - 1,
                    Integer.parseInt(line[3]));
            Date birthDate = calendar.getTime();
            return new Person(firstName, middleName, lastName, birthDate);
        }

        @Override
        public void close() throws IOException {
            this.fileScanner.close();
        }
    }
}
