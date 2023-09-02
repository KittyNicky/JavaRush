package com.javarush.task.task15.task1527;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Парсер реквестов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String url = reader.readLine();
        getParamsFromUrl(url);
    }

    public static void alert(double value) {
        System.out.println("double: " + value);
    }

    public static void alert(String value) {
        System.out.println("String: " + value);
    }

    public static void getParamsFromUrl(String url) {
        int beginIndex = url.lastIndexOf('?');

        String[] params = (url.substring(beginIndex + 1)).split("&");

        String result = "";
        String objValue = null;
        for (String param : params) {
            String[] splitParam = param.split("=");
            result += splitParam[0] + " ";
            if (splitParam[0].equals("obj")) {
                objValue = splitParam[1];
            }
        }
        System.out.println(result.trim());

        if (objValue != null) {
            try {
                alert(Double.parseDouble(objValue));
            } catch (NumberFormatException e) {
                alert(objValue);
            }
        }
    }
}
