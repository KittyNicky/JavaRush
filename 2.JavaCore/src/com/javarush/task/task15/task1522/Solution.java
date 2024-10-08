package com.javarush.task.task15.task1522;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Закрепляем паттерн Singleton
*/

public class Solution {
    public static void main(String[] args) {
    }

    public static Planet thePlanet;

    static {
        try {
            readKeyFromConsoleAndInitPlanet();
        } catch (IOException e) {
            System.out.println(e.getStackTrace());
        }
    }

    public static void readKeyFromConsoleAndInitPlanet() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String planet = reader.readLine();
        switch (planet) {
            case (Planet.EARTH):
                thePlanet = Earth.getInstance();
                break;
            case (Planet.SUN):
                thePlanet = Sun.getInstance();
                break;
            case (Planet.MOON):
                thePlanet = Moon.getInstance();
                break;
            default:
                thePlanet = null;
                break;
        }
    }
}
