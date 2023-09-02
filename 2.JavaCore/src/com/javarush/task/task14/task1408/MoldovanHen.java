package com.javarush.task.task14.task1408;

public class MoldovanHen extends Hen {
    public static final int countOfEggsPerMonth = 80;

    @Override
    public int getCountOfEggsPerMonth() {
        return countOfEggsPerMonth;
    }

    @Override
    public String getDescription() {
        return String.format("%s Моя страна - %s. Я несу %d яиц в месяц.",
                super.getDescription(), Country.MOLDOVA, getCountOfEggsPerMonth());    }
}
