package com.javarush.task.task31.task3102;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;

/* 
Находим все файлы
*/

public class Solution {
    public static List<String> getFileTree(String root) throws IOException {
        File folder = new File(root);
        Queue queue = new LinkedList();
        List<String> files = new LinkedList<>();
        queue.add(folder);

        while (queue.size() > 0) {
            folder = (File) queue.poll();
            for (File file : folder.listFiles()) {
                if (file.isDirectory())
                    queue.add(file);
                else files.add(file.getAbsolutePath());
            }
        }
        return files;
    }

    public static void main(String[] args) throws IOException {
        String path = "/Users/nikita.z/myJava/ideaProject/docs";
        for (String file : getFileTree(path)) {
            System.out.println(file);
        }
        System.out.println(new File(path).getPath());
    }
}
