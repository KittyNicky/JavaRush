package com.javarush.task.jdk13.task07.task0706;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Улица и дома
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int countPeopleOddSide = 0;
        int countPeopleEvenSide = 0;
        int[] ints = new int[15];

        for (int i = 0; i < ints.length; i++) {
            ints[i] = Integer.parseInt(reader.readLine());
            if (i % 2 == 0) {
                countPeopleEvenSide += ints[i];
            } else {
                countPeopleOddSide += ints[i];
            }
        }

        if (countPeopleOddSide > countPeopleEvenSide) {
            System.out.println("В домах с нечетными номерами проживает больше жителей.");
        } else if (countPeopleOddSide < countPeopleEvenSide) {
            System.out.println("В домах с четными номерами проживает больше жителей.");
        }


    }
}
