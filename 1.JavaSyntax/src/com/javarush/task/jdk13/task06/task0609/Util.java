package com.javarush.task.jdk13.task06.task0609;

/* 
Расстояние между двумя точками
*/

public class Util {
    public static double getDistance(int x1, int y1, int x2, int y2) {
        double distance = Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2));
        return distance;
    }

    public static void main(String[] args) {
        System.out.println(getDistance(1, 2, 3, 4));
    }
}
