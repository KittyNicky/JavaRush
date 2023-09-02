package com.javarush.task.task38.task3812;

/* 
Обработка аннотаций
*/

import java.lang.annotation.Annotation;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        printFullyQualifiedNames(Solution.class);
        printFullyQualifiedNames(SomeTest.class);

        printValues(Solution.class);
        printValues(SomeTest.class);
    }

    public static boolean printFullyQualifiedNames(Class c) {
        if (!c.isAnnotationPresent(PrepareMyTest.class)) {
            return false;
        } else {
            PrepareMyTest prepareMyTest = (PrepareMyTest) c.getAnnotation(PrepareMyTest.class);
            String[] fullyQualifiedNames = prepareMyTest.fullyQualifiedNames();
            System.out.println(Arrays.toString(fullyQualifiedNames));
            return true;
        }
    }

    public static boolean printValues(Class c) {
        if (!c.isAnnotationPresent(PrepareMyTest.class)) {
            return false;
        } else {
            PrepareMyTest prepareMyTest = (PrepareMyTest) c.getAnnotation(PrepareMyTest.class);
            Class<?>[] classes = prepareMyTest.value();
            Arrays.stream(classes).forEach(x -> System.out.println(x.getSimpleName()));
            return true;
        }
    }
}
