package com.javarush.task.task12.task1220;

/* 
Класс Human и интерфейсы CanRun, CanSwim
*/

public class Solution {
    public static void main(String[] args) {
        Snake snake = new Snake();
        Animal animal = new Animal();
        Animal snake2 = new Snake();
        snake2.voice();
        snake.voice();
        animal.voice();
    }

    public static class Animal {

        public void voice() {

            System.out.println("Голос!");
        }
    }

    public static class Snake extends Animal {
        @Override
        public void voice() {
            System.out.println("Sssss");
        }
    }
}
