package com.javarush.task.task19.task1906;

import java.io.*;
import java.util.ArrayList;

/* 
Четные символы
*/

public class Solution {
    public static void main(String[] args) {
        String fileName1 = null, fileName2 = null;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            fileName1 = reader.readLine();
            fileName2 = reader.readLine();
        } catch (IOException e) {
        }

        try (FileReader fileReader = new FileReader(fileName1);
             FileWriter fileWriter = new FileWriter(fileName2)) {
            int c = 1;
            while (fileReader.ready()) {
                int read = fileReader.read();
                if (c % 2 == 0) {
                    fileWriter.write(read);
                }
                c++;
            }
        } catch (IOException e) {
        }
    }
}
