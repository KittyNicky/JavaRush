package com.javarush.task.jdk13.task09.task0918;

/* 
Создаем свои исключения
*/

import java.io.FileNotFoundException;
import java.net.SocketException;

public class Solution {
    public static void main(String[] args) {
        int x = (int) Math.ceil(4.9);
        System.out.println(x);
    }

    static class MyException extends SocketException {
    }

    static class MyException2 extends FileNotFoundException {
    }

    static class MyException3 extends ArithmeticException {
    }

    static class MyException4 extends IndexOutOfBoundsException {
    }
}

