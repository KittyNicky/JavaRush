package com.javarush.task.task18.task1805;

import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/* 
Сортировка байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        printTreeSet(readFile(readFileName()));
    }

    private static String readFileName() {
        String fileName;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            fileName = reader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return fileName;
    }

    private static TreeSet<Integer> readFile(String fileName) {
        TreeSet<Integer> set = new TreeSet<Integer>();
        try (FileInputStream fileInputStream = new FileInputStream(fileName)) {
            while (fileInputStream.available() > 0) {
                set.add(fileInputStream.read());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return set;
    }

    public static void printTreeSet(TreeSet<Integer> treeSet) {
        for (Integer integer : treeSet) {
            System.out.print(integer + " ");
        }
    }
}
