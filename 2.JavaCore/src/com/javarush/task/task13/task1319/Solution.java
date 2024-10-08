package com.javarush.task.task13.task1319;

import java.io.*;

/* 
Писатель в файл с консоли
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new FileWriter("/Users/nikita.z/Без названия.txt"));
        while (true) {
            String string = reader.readLine();
            char[] stringSymbols = string.toCharArray();
            for (int i = 0; i < stringSymbols.length; i++) {
                int data = (int) stringSymbols[i];
                writer.write(data);
            }
            if (string.equals("exit")) break;
            writer.write((int) '\n');
        }
        reader.close();
        writer.close();
    }
}
