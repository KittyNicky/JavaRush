package com.javarush.task.jdk13.task09.task0927;

import java.util.*;

/* 
Десять котов
*/

public class Solution {

    public static void main(String[] args) {
        Map<String, Cat> map = createMap();
        Set<Cat> set = convertMapToSet(map);
        printCatSet(set);
    }

    public static Map<String, Cat> createMap() {
        Map<String, Cat> map = new HashMap<>();
        map.put("name1", new Cat("name1"));
        map.put("name2", new Cat("name2"));
        map.put("name3", new Cat("name3"));
        map.put("name4", new Cat("name4"));
        map.put("name5", new Cat("name5"));
        map.put("name6", new Cat("name6"));
        map.put("name7", new Cat("name7"));
        map.put("name8", new Cat("name8"));
        map.put("name9", new Cat("name9"));
        map.put("name10", new Cat("name10"));
        return map;
    }

    public static Set<Cat> convertMapToSet(Map<String, Cat> map) {
        Set<Cat> set= new HashSet<>(map.values());
        return set;
    }

    public static void printCatSet(Set<Cat> set) {
        for (Cat cat : set) {
            System.out.println(cat);
        }
    }

    public static class Cat {
        public String name;

        public Cat(String name) {
            this.name = name;
        }

        public String toString() {
            return "Cat " + this.name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (!(o instanceof Cat)) {
                return false;
            }
            Cat cat = (Cat) o;
            return Objects.equals(name, cat.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name);
        }
    }
}
