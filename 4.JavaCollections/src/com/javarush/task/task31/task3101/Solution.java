package com.javarush.task.task31.task3101;

import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;

/* 
Проход по дереву файлов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        if (args.length != 2) return;

        File path = new File(args[0]);
        File resultFileAbsolutePath = new File(args[1]);
        File file = new File(resultFileAbsolutePath.getParent() + "/allFilesContent.txt");

        if (FileUtils.isExist(file)) {
            FileUtils.deleteFile(file);
            FileUtils.renameFile(resultFileAbsolutePath, file);
        } else {
            FileUtils.renameFile(resultFileAbsolutePath, file);
        }

        Queue queue = new LinkedList();
        queue.add(path);
        String bufferedString;

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file))) {
            while (queue.size() > 0) {
                path = (File) queue.poll();
                for (File listFile : path.listFiles()) {
                    if (listFile.isDirectory()) {
                        queue.add(listFile);
                    } else {
                        if (listFile.length() <= 50) {
                            try (BufferedReader bufferedReader = new BufferedReader(new FileReader(listFile))) {
                                while ((bufferedString = bufferedReader.readLine()) != null) {
                                    bufferedWriter.write(bufferedString);
                                }
                                bufferedWriter.write("\n");
                            }
                        }
                    }
                }
            }
        }
    }
}
