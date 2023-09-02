package com.javarush.task.jdk13.task08.task0812;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Cамая длинная последовательность
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> numbers = new ArrayList<Integer>();

        for (int i = 0; i < 10; i++) {
            numbers.add(Integer.parseInt(reader.readLine()));
        }

        int maxLength = 1;
        int lengthOfCurrentRepetition = 1;
        for (int i = 1; i < numbers.size(); i++) {
            if (numbers.get(i - 1).equals(numbers.get(i))) {
                lengthOfCurrentRepetition += 1;
                if (lengthOfCurrentRepetition > maxLength) maxLength = lengthOfCurrentRepetition;
            } else {
                lengthOfCurrentRepetition = 1;
            }
        }
        System.out.println(maxLength);
    }

}
