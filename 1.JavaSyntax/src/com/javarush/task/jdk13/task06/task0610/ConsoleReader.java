package com.javarush.task.jdk13.task06.task0610;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Класс ConsoleReader
*/

public class ConsoleReader {
    public static String readString() throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String text = reader.readLine();
        return text;

    }

    public static int readInt() throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int intNumber = Integer.parseInt(reader.readLine());
        return intNumber;
    }

    public static double readDouble() throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        double doubleNumber = Double.parseDouble(reader.readLine());
        return doubleNumber;
    }

    public static boolean readBoolean() throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String stringBool = reader.readLine();
        boolean bool = stringBool.equals("true");
        return bool;

    }

    public static void main(String[] args) throws Exception {
    }
}
