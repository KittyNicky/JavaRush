package com.javarush.task.task10.task1013;

/* 
Конструкторы класса Human
*/

import java.util.Date;

public class Solution {
    public static void main(String[] args) {
    }

    public static class Human {
        private String firstName;
        private String secondName;
        private Date birthday;
        private int age;
        private int height;
        private int weight;

        public Human(String firstName) {
            this.firstName = firstName;
        }

        public Human(String firstName, String secondName) {
            this.firstName = firstName;
            this.secondName = secondName;
        }

        public Human(String firstName, Date birthday) {
            this.firstName = firstName;
            this.birthday = birthday;
        }

        public Human(String firstName, int age) {
            this.firstName = firstName;
            this.birthday = birthday;
        }

        public Human(String firstName, String secondName, Date birthday) {
            this.firstName = firstName;
            this.secondName = secondName;
            this.birthday = birthday;
        }

        public Human(String firstName, String secondName, int age) {
            this.firstName = firstName;
            this.secondName = secondName;
            this.age = age;
        }

        public Human(String firstName, String secondName, Date birthday, int age) {
            this.firstName = firstName;
            this.secondName = secondName;
            this.birthday = birthday;
            this.age = age;
        }

        public Human(String firstName, String secondName, int age, Date birthday) {
            this.firstName = firstName;
            this.secondName = secondName;
            this.age = age;
            this.birthday = birthday;
        }

        public Human(String firstName, String secondName, Date birthday, int age, int weight) {
            this.firstName = firstName;
            this.secondName = secondName;
            this.birthday = birthday;
            this.age = age;
            this.weight = weight;
        }

        public Human(String firstName, String secondName, Date birthday, int age, int weight, int height) {
            this.firstName = firstName;
            this.secondName = secondName;
            this.birthday = birthday;
            this.age = age;
            this.weight = weight;
            this.height = height;
        }
    }
}
