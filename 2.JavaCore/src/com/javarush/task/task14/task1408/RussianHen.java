package com.javarush.task.task14.task1408;

public class RussianHen extends Hen {
    public static final int countOfEggsPerMonth = 100;

    @Override
    public String getDescription() {
        return String.format("%s Моя страна - %s. Я несу %d яиц в месяц.",
                super.getDescription(), Country.RUSSIA, getCountOfEggsPerMonth());
    }

    @Override
    public int getCountOfEggsPerMonth() {
        return countOfEggsPerMonth;
    }
}
