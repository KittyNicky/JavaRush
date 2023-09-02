package com.javarush.task.jdk13.task09.task0926;

import java.util.ArrayList;
import java.util.Arrays;

/* 
Список из массивов чисел
*/

public class Solution {

    public static void main(String[] args) {
        ArrayList<int[]> list = createList();
        printList(list);
    }

    public static ArrayList<int[]> createList() {
        ArrayList<int[]> numbers = new ArrayList<>();
        int[] m1 = {1, 2, 3, 4, 5};
        int[] m2 = {1, 2};
        int[] m3 = {1, 2, 3, 4};
        int[] m4 = {1, 2, 3, 4, 5, 6, 7};
        int[] m5 = {};
        numbers.add(m1);
        numbers.add(m2);
        numbers.add(m3);
        numbers.add(m4);
        numbers.add(m5);
        return numbers;
    }

    public static void printList(ArrayList<int[]> list) {
        for (int[] array : list) {
            System.out.println(Arrays.toString(array));
        }
    }
}
