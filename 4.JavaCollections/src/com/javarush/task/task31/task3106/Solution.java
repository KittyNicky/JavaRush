package com.javarush.task.task31.task3106;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/*
Разархивируем файл
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        String resultFileName = args[0];
        List<String> archives = new ArrayList<>();
        for (int i = 1; i < args.length; i++) {
            archives.add(args[i]);
        }
        Collections.sort(archives);

        List<FileInputStream> fileInputStreams = new ArrayList<>();
        for (String archive : archives) {
            fileInputStreams.add(new FileInputStream(archive));
        }

        try (ZipInputStream zipInputStream = new ZipInputStream(new SequenceInputStream(Collections.enumeration(fileInputStreams)));
             FileOutputStream fileOutputStream = new FileOutputStream(resultFileName)
        ) {
            while (zipInputStream.getNextEntry() != null) {
                byte[] buffer = new byte[1024];
                int len;
                while ((len = zipInputStream.read(buffer)) != -1) {
                    fileOutputStream.write(buffer, 0, len);
                }
            }
        }
    }
}
