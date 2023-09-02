package com.javarush.task.task17.task1721;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Транзакционность
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    static {
        // read two files path names
        String fileName1;
        String fileName2;
        try {
            fileName1 = reader.readLine();
            fileName2 = reader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // read two files line by line
        try (BufferedReader readerFileName1 = new BufferedReader(new FileReader(fileName1))) {
            String line;
            while ((line = readerFileName1.readLine()) != null) {
                allLines.add(line);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try (BufferedReader readerFileName2 = new BufferedReader(new FileReader(fileName2))) {
            String line;
            while ((line = readerFileName2.readLine()) != null) {
                forRemoveLines.add(line);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        try {
            new Solution().joinData();
        } catch (CorruptedDataException e) {
            throw new RuntimeException(e);
        }
    }

    public void joinData() throws CorruptedDataException {
        int sizeForRemoveLine = forRemoveLines.size();
        int countContains = 0;
        for (String forRemoveLine : forRemoveLines) {
            if (allLines.contains(forRemoveLine)) countContains++;
        }
        if (sizeForRemoveLine == countContains) allLines.removeAll(forRemoveLines);
        else {
            allLines.clear();
            throw new CorruptedDataException();
        }
    }
}
