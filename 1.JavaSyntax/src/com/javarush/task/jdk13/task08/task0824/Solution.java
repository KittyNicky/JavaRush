package com.javarush.task.jdk13.task08.task0824;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* 
Вся семья в сборе
*/

public class Solution {
    public static void main(String[] args) {
        ArrayList<Object> objects = new ArrayList<>();

        ArrayList<Human> childrenByFatherAndMother = new ArrayList<>();
        Human children1 = new Human("children1", true, 10, new ArrayList<>());
        Human children2 = new Human("children2", false, 11, new ArrayList<>());
        Human children3 = new Human("children3", true, 12, new ArrayList<>());
        childrenByFatherAndMother.add(children1);
        childrenByFatherAndMother.add(children2);
        childrenByFatherAndMother.add(children3);

        ArrayList<Human> childrenByGrandFather1AndGrandMother1 = new ArrayList<>();
        ArrayList<Human> childrenByGrandFather2AndGrandMother2 = new ArrayList<>();
        Human father = new Human("father", true, 30, childrenByFatherAndMother);
        Human mother = new Human("mother", false, 30, childrenByFatherAndMother);
        childrenByGrandFather1AndGrandMother1.add(father);
        childrenByGrandFather2AndGrandMother2.add(mother);

        Human grandFather1 = new Human("grandFather1", true, 60, childrenByGrandFather1AndGrandMother1);
        Human grandMother1 = new Human("grandMother1", false, 60, childrenByGrandFather1AndGrandMother1);
        Human grandFather2 = new Human("grandFather2", true, 70, childrenByGrandFather2AndGrandMother2);
        Human grandMother2 = new Human("grandMother2", false, 70, childrenByGrandFather2AndGrandMother2);

        objects.add(children1);
        objects.add(children2);
        objects.add(children3);
        objects.add(father);
        objects.add(mother);
        objects.add(grandFather1);
        objects.add(grandMother1);
        objects.add(grandFather2);
        objects.add(grandMother2);

        for (Object object : objects) {
            System.out.println(object);
        }
    }

    public static class Human {
        String name;
        boolean sex;
        int age;
        ArrayList<Human> children;

        public Human(String name, boolean sex, int age, ArrayList<Human> children) {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.children = children;
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

            int childCount = this.children.size();
            if (childCount > 0) {
                text += ", дети: " + this.children.get(0).name;

                for (int i = 1; i < childCount; i++) {
                    Human child = this.children.get(i);
                    text += ", " + child.name;
                }
            }
            return text;
        }
    }
}
