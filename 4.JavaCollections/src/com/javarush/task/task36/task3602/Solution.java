package com.javarush.task.task36.task3602;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Collections;
import java.util.List;

/* 
Найти класс по описанию Ӏ Java Collections: 6 уровень, 6 лекция
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(getExpectedClass());
    }

    public static Class getExpectedClass() {
        for (Class<?> clazz : Collections.class.getDeclaredClasses()) {
            // implements interface "List"
            if (List.class.isAssignableFrom(clazz)) {
                // class is static and private
                if (Modifier.isStatic(clazz.getModifiers()) && Modifier.isPrivate(clazz.getModifiers())) {
                    //index access denied - Throws IndexOutOfBoundsException
                    try {
                        Method method = clazz.getMethod("get", int.class);
                        method.setAccessible(true);
                        Constructor constructor = clazz.getDeclaredConstructor();
                        constructor.setAccessible(true);

                        method.invoke(constructor.newInstance(), 0);
                    } catch (InvocationTargetException e) {
                        if (e.getTargetException().getClass().getSimpleName().equals("IndexOutOfBoundsException"))
                            return clazz;
                    } catch (Exception e) {
                    }
                }
            }
        }
        return null;
    }
}
