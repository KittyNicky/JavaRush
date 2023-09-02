package com.javarush.task.task19.task1914;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;

/* 
Решаем пример
*/

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream consoleStream = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);
        testString.printSomething();
        System.setOut(consoleStream);
        String result = outputStream.toString();
        String[] arrResult = result.split(" ");
        int firstNumber = Integer.parseInt(arrResult[0]);
        int secondNumber = Integer.parseInt(arrResult[2]);
        String resOfCalc = null;
        if (arrResult[1].equals("+")) resOfCalc = String.valueOf(firstNumber + secondNumber);
        if (arrResult[1].equals("-")) resOfCalc = String.valueOf(firstNumber - secondNumber);
        if (arrResult[1].equals("*")) resOfCalc = String.valueOf(firstNumber * secondNumber);
        System.out.println(result + resOfCalc);
    }

    public static class TestString {
        public void printSomething() {
            System.out.print("3 + 6 = ");
        }
    }
}

