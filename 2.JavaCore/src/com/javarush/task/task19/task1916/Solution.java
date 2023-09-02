package com.javarush.task.task19.task1916;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* 
Отслеживаем изменения
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) {
        String originalFile = null;
        String correctedFile = null;

        // read original and corrected file names
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            originalFile = bufferedReader.readLine();
            correctedFile = bufferedReader.readLine();
        } catch (IOException e) {
        }

        // read original and corrected files -> add lines in two lists
        List<String> originalLines = new ArrayList<String>();
        List<String> correctedLines = new ArrayList<String>();
        try (BufferedReader originalReader = new BufferedReader(new FileReader(originalFile));
             BufferedReader correctedReader = new BufferedReader(new FileReader(correctedFile))) {
            while (originalReader.ready()) {
                originalLines.add(originalReader.readLine());
            }
            while (correctedReader.ready()) {
                correctedLines.add(correctedReader.readLine());
            }
        } catch (IOException e) {
        }

        // merged file generation cycle
        int original = 0, corrected = 0;
        while (corrected < correctedLines.size() && original < originalLines.size()) {
            if (originalLines.get(original).equals(correctedLines.get(corrected))) {
                lines.add(new LineItem(Type.SAME, originalLines.get(original)));
                original++;
                corrected++;
            } else if (original + 1 < originalLines.size() && originalLines.get(original + 1).equals(correctedLines.get(corrected))) {
                lines.add(new LineItem(Type.REMOVED, originalLines.get(original)));
                original++;
            } else if (corrected + 1 < correctedLines.size() && originalLines.get(original).equals(correctedLines.get(corrected + 1))) {
                lines.add(new LineItem(Type.ADDED, correctedLines.get(corrected)));
                corrected++;
            }
        }
        while (original < originalLines.size()) {
            lines.add(new LineItem(Type.REMOVED, originalLines.get(original)));
            original++;
        }
        while (corrected < correctedLines.size()) {
            lines.add(new LineItem(Type.ADDED, correctedLines.get(corrected)));
            corrected++;
        }
    }


    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }

        @Override
        public String toString() {
            return String.format("%s %s", type, line);
        }
    }
}
