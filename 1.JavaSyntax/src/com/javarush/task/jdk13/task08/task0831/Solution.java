package com.javarush.task.jdk13.task08.task0831;

import java.util.Arrays;

/* 
Любимые настолки
*/

public class Solution {

    public static BoardGame[] collection = new BoardGame[5];

    public static void main(String[] args) {
        BoardGame chess = new BoardGame();
        chess.name = "Шахматы";
        collection[0] = chess;

        BoardGame monopoly = new BoardGame();
        monopoly.name = "Монополия";
        collection[1] = monopoly;

        BoardGame gloomhaven = new BoardGame();
        gloomhaven.name = "GLOOMHAVEN";
        collection[2] = gloomhaven;

        BoardGame manchkin = new BoardGame();
        manchkin.name = "Манчкин";
        collection[3] = manchkin;

        BoardGame evolution = new BoardGame();
        evolution.name = "Эволюция";
        collection[4] = evolution;


        System.out.println(Arrays.toString(collection));
    }
}