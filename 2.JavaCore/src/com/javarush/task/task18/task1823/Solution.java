package com.javarush.task.task18.task1823;

import java.io.*;
import java.util.*;

/* 
Нити и байты
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName;
        try {
            while (!(fileName = reader.readLine()).equals("exit")) {
                new ReadThread(fileName).start();
            }
        } catch (IOException e) {
        }
    }

    public static class ReadThread extends Thread {
        private String fileName;

        public ReadThread(String fileName) {
            this.fileName = fileName;
        }

        @Override
        public void run() {
            Map<Integer, Integer> map = new HashMap<>();
            try (FileInputStream fileInputStream = new FileInputStream(fileName)) {
                int c;
                while (fileInputStream.available() > 0) {
                    c = fileInputStream.read();
                    if (map.containsKey(c)) map.replace(c, map.get(c) + 1);
                    else map.put(c, 1);
                }
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            ArrayList<Integer> keyList = new ArrayList<>(map.keySet());
            Collections.sort(keyList);

            int maxValue = 0;
            int keyValue = 0;
            for (Integer key : keyList) {
                int mapValue = map.get(key);
                if (mapValue > maxValue) {
                    maxValue = mapValue;
                    keyValue = key;
                }
            }
            resultMap.put(fileName, keyValue);
        }
    }
}
