package com.javarush.task.jdk13.task08.task0803;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* 
Коллекция Map из котов
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        String[] catsArray = new String[]{"васька", "мурка", "дымка", "рыжик", "серый", "снежок", "босс", "борис", "визя", "гарфи"};

        Map<String, Cat> map = addCatsToMap(catsArray);

        for (Map.Entry<String, Cat> pair : map.entrySet()) {
            System.out.println(pair.getKey() + " - " + pair.getValue());
        }
    }


    public static Map<String, Cat> addCatsToMap(String[] cats) {
        Map<String, Cat> map = new HashMap<String, Cat>();
        for (int i = 0; i < cats.length; i++) {
            Cat cat = new Cat(cats[i]);
            map.put(cats[i], cat);
        }
        return map;
    }


    public static class Cat {
        String name;

        public Cat(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return name != null ? name.toUpperCase() : null;
        }
    }
}
