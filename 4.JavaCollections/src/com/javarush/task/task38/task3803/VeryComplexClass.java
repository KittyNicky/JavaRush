package com.javarush.task.task38.task3803;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/* 
Runtime исключения (unchecked exception)
*/

public class VeryComplexClass {
    public void methodThrowsClassCastException() {
        Object object = Integer.valueOf(10);
        String str = (String) object;
    }

    public void methodThrowsNullPointerException() {
        Integer i = null;
        System.out.println(i.toString());
    }

    public static void main(String[] args) {

    }
}
