package com.javarush.task.task35.task3507;

import com.javarush.task.task35.task3507.data.Cat;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Set;

/* 
ClassLoader - что это такое?
*/

public class Solution {
    public static void main(String[] args) {
        Set<? extends Animal> allAnimals = getAllAnimals(Solution.class.getProtectionDomain().getCodeSource().getLocation().getPath() + Solution.class.getPackage().getName().replaceAll("[.]", "/") + "/data");
    }

    public static Set<? extends Animal> getAllAnimals(String pathToAnimals) {
        if (!pathToAnimals.endsWith("\\") && !pathToAnimals.endsWith("/")) pathToAnimals = pathToAnimals + "/";

        Set<Animal> set = new HashSet<>();
        MyClassLoader classLoader = new MyClassLoader();

        File path = new File(pathToAnimals);
        File[] files = path.listFiles();
        for (File file : files) {
            try {
                Class<?> cls = classLoader.loadClass(file.getAbsolutePath());
                if (Animal.class.isAssignableFrom(cls)) {
                    Constructor<?> constructor = cls.getConstructor();
                    if (constructor.getParameterCount() == 0) set.add((Animal) constructor.newInstance());
                }
            } catch (Exception e) {
            }
        }
        return set;
    }

    public static class MyClassLoader extends ClassLoader {

        @Override
        public Class<?> findClass(String name) {
            Class cls = null;

            try {
                byte[] buffer = Files.readAllBytes(Paths.get(name));
                cls = defineClass(null, buffer, 0, buffer.length);
            } catch (IOException e) {
                e.printStackTrace();
            }

            return cls;
        }
    }
}
