package com.javarush.task.jdk13.task07.task0724;

/* 
Семья
*/

public class Solution {
    public static void main(String[] args) {
        Human grandFather1 = new Human("grandFather1", true, 81);
        Human grandMother1 = new Human("grandMother1", false, 81);
        Human grandFather2 = new Human("grandFather2", true, 82);
        Human grandMother2 = new Human("grandMother2", false, 82);

        Human father1 = new Human("father1", true, 51, grandFather1, grandMother1);
        Human mother1 = new Human("mother1", false, 51, grandFather2, grandMother2);

        Human child1 = new Human("child1", true, 1, father1, mother1);
        Human child2 = new Human("child2", false, 2, father1, mother1);
        Human child3 = new Human("child3", true, 3, father1, mother1);

        System.out.println(grandFather1);
        System.out.println(grandMother1);
        System.out.println(grandFather2);
        System.out.println(grandMother2);

        System.out.println(father1);
        System.out.println(mother1);

        System.out.println(child1);
        System.out.println(child2);
        System.out.println(child3);

    }

    public static class Human {
        String name;
        boolean sex;
        int age;
        Human father;
        Human mother;

        public Human(String name, boolean sex, int age, Human father, Human mother) {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.father = father;
            this.mother = mother;
        }

        public Human(String name, boolean sex, int age) {
            this.name = name;
            this.sex = sex;
            this.age = age;
        }

        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            if (this.father != null) {
                text += ", отец: " + this.father.name;
            }

            if (this.mother != null) {
                text += ", мать: " + this.mother.name;
            }

            return text;
        }
    }
}