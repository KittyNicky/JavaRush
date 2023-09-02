package com.javarush.task.jdk13.task05.task0501;

/* 
Кошачья бойня(3)
*/

public class Solution {
    public static void main(String[] args) {
        Solution.Cat cat1 = new Solution.Cat("Tom", 2, 2, 2);
        Solution.Cat cat2 = new Solution.Cat("Sam", 2, 2, 2);
        Solution.Cat cat3 = new Solution.Cat("Fiona", 3, 3, 3);

        System.out.println(cat1.fight(cat2));
        System.out.println(cat2.fight(cat3));
        System.out.println(cat3.fight(cat1));
    }

    public static class Cat {
        private String name;
        private int age;
        private int weight;
        private int strength;

        public Cat(String name, int age, int weight, int strength) {
            this.name = name;
            this.age = age;
            this.weight = weight;
            this.strength = strength;
        }

        public boolean fight(Cat anotherCat) {
            int ageScore = Integer.compare(this.age, anotherCat.age);
            int weightScore = Integer.compare(this.weight, anotherCat.weight);
            int strengthScore = Integer.compare(this.strength, anotherCat.strength);

            int score = ageScore + weightScore + strengthScore;
            return score > 0;
        }
    }
}
