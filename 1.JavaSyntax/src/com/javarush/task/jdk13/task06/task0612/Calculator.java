package com.javarush.task.jdk13.task06.task0612;

/* 
Класс Calculator
*/

public class Calculator {
    public static int plus(int a, int b) {
        return (a + b);
    }

    public static int minus(int a, int b) {
        return (a - b);
    }

    public static int multiply(int a, int b) {
        return (a * b);
    }

    public static double division(int a, int b) {
        return ((double) a / b);
    }

    public static double percent(int a, int b) {
        return (a * (b * 0.01));
    }

    public static void main(String[] args) {
    }
}