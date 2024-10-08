package com.javarush.task.jdk13.task09.task0906;

/* 
Логирование стек трейса
*/

public class Solution {

    public static void main(String[] args) {
        log("In method");
    }

    public static void log(String text) {
        String className = Thread.currentThread().getStackTrace()[2].getClassName();
        String methodName = Thread.currentThread().getStackTrace()[2].getMethodName();
        System.out.println(className + ": " + methodName + ": " + text);
    }
}
