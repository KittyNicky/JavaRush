package com.javarush.task.jdk13.task05.task0517;

/* 
Конструируем котиков
*/

public class Cat {
    public final int BASIC_AGE = 2;
    public final int BASIC_WEIGHT = 2;
    public final String BASIC_COLOR = "black";

    private String name;
    private int age;
    private int weight;
    private String address;
    private String color;

    public Cat(String name) {
        this.name = name;
        this.age = BASIC_AGE;
        this.weight = BASIC_WEIGHT;
        this.color = BASIC_COLOR;
    }

    public Cat(String name, int weight, int age) {
        this.name = name;
        this.weight = weight;
        this.age = age;
        this.color = BASIC_COLOR;
    }

    public Cat(String name, int age) {
        this.name = name;
        this.age = age;
        this.weight = BASIC_WEIGHT;
        this.color = BASIC_COLOR;
    }

    public Cat(int weight, String color) {
        this.weight = weight;
        this.color = color;
        this.age = BASIC_AGE;
    }

    public Cat(int weight, String color, String address) {
        this.weight = weight;
        this.color = color;
        this.address = address;
        this.age = BASIC_AGE;
    }

    public static void main(String[] args) {

    }
}
