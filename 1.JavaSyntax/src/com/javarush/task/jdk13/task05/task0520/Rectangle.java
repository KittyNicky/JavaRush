package com.javarush.task.jdk13.task05.task0520;

/* 
Заполнить класс прямоугольник (Rectangle)
*/


public class Rectangle {
    private int left, top, width, height;

    public Rectangle (int left) {
        this.left = left;
    }
    public Rectangle (int left, int top) {
        this.left = left;
        this.top = top;
    }
    public Rectangle (int left, int top, int width) {
        this.left = left;
        this.top = top;
        this.width = width;
    }
    public Rectangle (int left, int top, int width, int height) {
        this.left = left;
        this.top = top;
        this.width = width;
        this.height = height;
    }

    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle(1,2,3,4);
        System.out.println(rectangle.height);
    }
}
