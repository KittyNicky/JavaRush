package com.javarush.task.jdk13.task05.task0527;

/* 
Том и Джерри
*/

public class Solution {
    public static void main(String[] args) {
        Mouse jerryMouse = new Mouse("Jerry", 12, 5);
        Dog bullDog = new Dog("Bull", 5, "Korgi");
        Cat tomCat = new Cat("Tom", 5, "BritishCat");
        System.out.println(jerryMouse);
        System.out.println(bullDog);
        System.out.println(tomCat);
        //напишите тут ваш код
    }

    public static class Mouse {
        String name;
        int height;
        int tail;

        public Mouse(String name, int height, int tail) {
            this.name = name;
            this.height = height;
            this.tail = tail;
        }

        @Override
        public String toString() {
            return name + " - " + height + " - " + tail;
        }
    }


    public static class Dog {
        private String name;
        private int age;
        private String breed;

        public Dog(String name, int age, String breed) {
            this.name = name;
            this.age = age;
            this.breed = breed;
        }

        @Override
        public String toString() {
            return name + " - " + breed + " - " + age;
        }
    }

    public static class Cat {
        private String name;
        private int age;
        private String breed;

        public Cat(String name, int age, String breed) {
            this.name = name;
            this.age = age;
            this.breed = breed;
        }

        @Override
        public String toString() {
            return name + " - " + breed + " - " + age;
        }
    }

}