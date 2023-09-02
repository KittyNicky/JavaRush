package com.javarush.task.task31.task3113;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.*;

/* 
Что внутри папки?
*/

public class Solution {

    public static void main(String[] args) throws IOException {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            MyFileVisitor fileVisitor = new MyFileVisitor();
            Path path = Paths.get(bufferedReader.readLine());
            fileVisitor.setPath(path);

            if (MyFileVisitor.isDirectory(path)) return;
            Files.walkFileTree(path, fileVisitor);
            System.out.println(fileVisitor);
        }
    }
}
