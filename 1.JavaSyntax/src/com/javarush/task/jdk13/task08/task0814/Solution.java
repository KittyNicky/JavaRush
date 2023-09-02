package com.javarush.task.jdk13.task08.task0814;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* 
Больше 10? Вы нам не подходите
*/

public class Solution {
    public static Set<Integer> createSet() {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < 20; i++) {
            int number = i * 10 + 10 / (i + 1);
            set.add(number);
        }
        return set;
    }

    public static void removeAllNumbersGreaterThan10(Set<Integer> set) {
        Set<Integer> copy = new HashSet<>(set);
        for (Integer number : copy) {
            if (number > 10) set.remove(number);
        }

    }

    public static void main(String[] args) {
        Set<Integer> integers = createSet();
        for (Integer integer : integers) {
            System.out.println(integer);
        }
        removeAllNumbersGreaterThan10(integers);
        for (Integer integer : integers) {
            System.out.println(integer);
        }

    }
}
