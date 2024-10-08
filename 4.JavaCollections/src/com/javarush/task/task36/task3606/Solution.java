package com.javarush.task.task36.task3606;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

/* 
Осваиваем ClassLoader и Reflection
*/

public class Solution {
    private List<Class> hiddenClasses = new ArrayList<>();
    private String packageName;

    public Solution(String packageName) {
        this.packageName = packageName;
    }

    public static void main(String[] args) throws ClassNotFoundException {
        Solution solution = new Solution(Solution.class.getProtectionDomain().getCodeSource().getLocation().getPath() + "com/javarush/task/task36/task3606/data/second");
        solution.scanFileSystem();
        System.out.println(solution.getHiddenClassObjectByKey("secondhiddenclassimpl"));
        System.out.println(solution.getHiddenClassObjectByKey("firsthiddenclassimpl"));
        System.out.println(solution.getHiddenClassObjectByKey("packa"));
    }

    public void scanFileSystem() throws ClassNotFoundException {
        String sep = System.getProperty("file.separator");
        if (!packageName.endsWith(sep)) packageName += sep;

        File dir = new File(packageName);
        ClassLoader classLoader = Solution.class.getClassLoader();
        for (String fileName : dir.list()) {
            if (fileName.endsWith(".class")) {
                String clsPath = packageName.concat(fileName);
                String clsName = clsPath.substring(packageName.lastIndexOf("ru/"), clsPath.length() - 6).replaceAll(sep, ".");
                Class<?> cls = classLoader.loadClass(clsName);
                hiddenClasses.add(cls);
            }
        }
    }


    public HiddenClass getHiddenClassObjectByKey(String key) {
        key = key.toLowerCase();
        try {
            Class hiddenClass;
            for (Class cls : hiddenClasses) {
                if (cls.getSimpleName().toLowerCase().startsWith(key)) {
                    hiddenClass = cls;
                    Constructor<?> constructor = hiddenClass.getDeclaredConstructor();
                    constructor.setAccessible(true);
                    return (HiddenClass) constructor.newInstance();
                }
            }
        } catch (InvocationTargetException | InstantiationException | IllegalAccessException |
                 NoSuchMethodException e) {
            e.printStackTrace();
        }
        return null;
    }
}

