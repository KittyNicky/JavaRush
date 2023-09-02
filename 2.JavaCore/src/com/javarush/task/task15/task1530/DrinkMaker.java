package com.javarush.task.task15.task1530;

public abstract class DrinkMaker {
    //выбрать подходящую чашку
    public abstract void getRightCup();

    //положить ингредиенты
    public abstract void putIngredient();

    //залить жидкость
    public abstract void pour();

    //приготовить напиток
    public void makeDrink() {
        getRightCup();
        putIngredient();
        pour();
    }
}
