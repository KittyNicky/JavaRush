package com.javarush.task.jdk13.task05.task0510;

/* 
Кошкоинициация
*/

public class Cat {
    private final int BASIC_AGE = 2;
    private final int BASIC_WEIGHT = 3;
    private final String BASIC_COLOR = "black";
    private String name;
    private int age;
    private int weight;
    private String address;
    private String color = "black";

    public void initialize(String name) {
        this.name = name;
        this.weight = BASIC_WEIGHT;
        this.age = BASIC_AGE;
        this.color = BASIC_COLOR;
    }

    public void initialize(String name, int weight, int age) {
        this.name = name;
        this.weight = weight;
        this.age = age;
    }

    public void initialize(String name, int age) {
        this.name = name;
        this.age = age;
        this.weight = BASIC_WEIGHT;
    }

    public void initialize(int weight, String color) {
        this.weight = weight;
        this.color = color;
        this.age = BASIC_AGE;
    }

    public void initialize(int weight, String color, String address) {
        this.weight = weight;
        this.color = color;
        this.address = address;
        this.age = BASIC_AGE;
    }

    public static void main(String[] args) {

        Cat cat = new Cat();
        cat.initialize("vasya", 4);
        System.out.println(cat.name + " - " + cat.color + " - " + cat.address + " - " + cat.weight + " - " + cat.age);
    }
}
