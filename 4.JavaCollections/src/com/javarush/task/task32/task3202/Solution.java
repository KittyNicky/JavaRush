package com.javarush.task.task32.task3202;

import java.io.*;

/* 
Читаем из потока
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        StringWriter writer = getAllDataFromInputStream(new FileInputStream("/Users/nikita.z/myJava/ideaProject/docs/2.txt"));
        System.out.println(writer.toString());
    }

    public static StringWriter getAllDataFromInputStream(InputStream is) throws IOException {
        StringWriter writer = new StringWriter();
        if (is != null) {
            char[] buffer = new char[1024];
            int len;
            try (Reader reader = new BufferedReader(new InputStreamReader(is))) {
                while ((len = reader.read(buffer)) > 0) {
                    writer.write(buffer, 0, len);
                }
            }
        }
        return writer;
    }
}
