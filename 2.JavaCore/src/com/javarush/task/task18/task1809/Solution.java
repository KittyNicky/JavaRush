package com.javarush.task.task18.task1809;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* 
Реверс файла
*/

public class Solution {
    private static final int countFiles = 2;
    private static String[] files = new String[countFiles];

    static {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            for (int i = 0; i < files.length; i++) {
                files[i] = reader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        writeReverseFile();
    }

    public static void writeReverseFile() {
        try (FileInputStream fileInputStream = new FileInputStream(files[0]);
             FileOutputStream fileOutputStream = new FileOutputStream(files[1])) {

            ArrayList<Integer> inputBytes = new ArrayList<>();
            while (fileInputStream.available() > 0) {
                inputBytes.add(fileInputStream.read());
            }

            Collections.reverse(inputBytes);
            for (Integer inputByte : inputBytes) {
                fileOutputStream.write(inputByte);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
