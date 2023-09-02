package com.javarush.task.task18.task1808;

import java.io.*;

/* 
Разделение файла
*/

public class Solution {
    private static String[] fileNames;
    private static final int count = 3;

    public static void main(String[] args) throws Exception {
        readFileNames(count);
        readAndWriteFiles();
    }

    private static void readFileNames(int count) {
        fileNames = new String[count];
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            for (int i = 0; i < count; i++) {
                fileNames[i] = reader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void readAndWriteFiles() throws Exception {
        FileInputStream fileInputStream = new FileInputStream(fileNames[0]);
        FileOutputStream fileOutputStream1 = new FileOutputStream(fileNames[1]);
        FileOutputStream fileOutputStream2 = new FileOutputStream(fileNames[2]);

        int sizeFile = fileInputStream.available();
        if (sizeFile > 0) {
            int sizeBuffer1, sizeBuffer2;
            if (sizeFile % 2 == 1) sizeBuffer1 = sizeFile / 2 + 1;
            else sizeBuffer1 = sizeFile / 2;
            sizeBuffer2 = sizeFile / 2;

            byte[] buffer1 = new byte[sizeBuffer1];
            byte[] buffer2 = new byte[sizeBuffer2];

            int countBuffer1 = fileInputStream.read(buffer1, 0, sizeBuffer1);
            int countBuffer2 = fileInputStream.read(buffer2, 0, sizeBuffer2);

            fileOutputStream1.write(buffer1, 0, countBuffer1);
            fileOutputStream2.write(buffer2, 0, countBuffer2);
        }
        fileInputStream.close();
        fileOutputStream1.close();
        fileOutputStream2.close();
    }
}
