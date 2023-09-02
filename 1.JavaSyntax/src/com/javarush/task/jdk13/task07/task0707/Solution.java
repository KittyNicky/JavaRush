package com.javarush.task.jdk13.task07.task0707;

import java.util.ArrayList;

/* 
5 различных строк в списке
*/

public class Solution {

    public static ArrayList<String> list;

    public static void main(String[] args) {
        list = new ArrayList<String>();
        int count = 5;
        String text = "text";
        for (int i = 0; i < count; i++) {
            list.add(text);
            text += ":" + text;
        }

        System.out.println(list.size());

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
