package com.javarush.task.jdk13.task07.task0720;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Перестановочка подоспела
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(reader.readLine());
        int M = Integer.parseInt(reader.readLine());

        ArrayList<String> listN = new ArrayList<String>();
        for (int i = 0; i < N; i++) {
            listN.add(reader.readLine());
        }

        for (int i = 0; i < M; i++) {
            listN.add(listN.get(0));
            listN.remove(0);
        }

        for (int i = 0; i < listN.size(); i++) {
            System.out.println(listN.get(i));
        }
    }
}
