package com.javarush.task.task18.task1826;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/* 
Шифровка
*/

public class Solution {
    private static final int encryptVar = 33;

    public static void main(String[] args) {
        readParams(args);
    }

    private static boolean validateArgs(String[] args) {
        if (args.length != 3) return false;
        if (!(args[0].equals("-e") || args[0].equals("-d"))) return false;
        return true;
    }

    private static void readParams(String[] args) {
        if (validateArgs(args)) {
            switch (args[0]) {
                case ("-d"): {
                    decryptData(args[1], args[2]);
                    break;
                }
                case ("-e"): {
                    encryptData(args[1], args[2]);
                    break;
                }
            }
        }
    }

    private static void encryptData(String fileName, String fileOutputName) {
        try (FileInputStream fileInputStream = new FileInputStream(fileName);
             FileOutputStream fileOutputStream = new FileOutputStream(fileOutputName)) {
            while (fileInputStream.available() > 0) {
                fileOutputStream.write(fileInputStream.read() + encryptVar);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void decryptData(String fileName, String fileOutputName) {
        try (FileInputStream fileInputStream = new FileInputStream(fileName);
             FileOutputStream fileOutputStream = new FileOutputStream(fileOutputName)) {
            while (fileInputStream.available() > 0) {
                fileOutputStream.write(fileInputStream.read() - encryptVar);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
