package com.javarush.task.jdk13.task05.task0528;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/* 
Вывести на экран сегодняшнюю дату
*/

public class Solution {
    public static void main(String[] args) {
        Calendar calendar = new GregorianCalendar();
        String today = calendar.get(calendar.DATE) + " " + (int) (calendar.get(calendar.MONTH) + 1) + " " + calendar.get(calendar.YEAR);
        System.out.println(today);
    }
}
