package com.javarush.task.task39.task3901;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

/* 
Уникальные подстроки
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Please enter your string: ");
        String s = bufferedReader.readLine();

        System.out.println("The longest unique substring length is: \n" + lengthOfLongestUniqueSubstring(s));
    }

    public static int lengthOfLongestUniqueSubstring(String s) {
        if (s == null || s.equals("")) return 0;
        char[] chars = s.toCharArray();
        int longestSubstringLength = 0;
        Set<Character> charSet = new HashSet<>();

        for (int i = 0; i < chars.length; i++) {
            if (charSet.size() > longestSubstringLength) {
                longestSubstringLength = charSet.size();
            }

            charSet.clear();
            for (int j = i; j < chars.length; j++) {
                if (charSet.contains(chars[j])) break;
                else charSet.add(chars[j]);
            }
        }
        return Math.max(charSet.size(), longestSubstringLength);
    }
}
