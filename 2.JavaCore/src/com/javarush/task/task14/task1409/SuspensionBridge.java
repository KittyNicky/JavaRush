package com.javarush.task.task14.task1409;

public class SuspensionBridge implements Bridge{
    public static final int countCars = 100;
    @Override
    public int getCarsCount() {
        return countCars;
    }
}
