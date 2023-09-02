package com.javarush.task.task19.task1911;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/* 
Ридер обертка
*/

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        //запоминаем настоящий PrintStream в специальную переменную
        PrintStream consoleStream = System.out;

        //Создаем динамический массив
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        //создаем адаптер к классу PrintStream
        PrintStream printStream = new PrintStream(outputStream);
        //Устанавливаем его как текущий System.out
        System.setOut(printStream);

        // Вызываем функцию println объекта System.out
        testString.printSomething();
        // Преобразовываем записанные в наш ByteArray данные в строку
        String result = outputStream.toString();

        // Возвращаем как было
        System.setOut(consoleStream);
        // Вывод результата
        System.out.println(result.toUpperCase());
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}
