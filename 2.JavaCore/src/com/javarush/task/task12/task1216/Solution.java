package com.javarush.task.task12.task1216;

/* 
Летать охота
*/

public class Solution {
    public static void main(String[] args) {

    }

    public interface CanFly {
        void fly1();

        void fly2();
    }

    public class Bird implements CanFly {
        @Override
        public void fly1() {
        }

        @Override
        public void fly2() {
        }
    }
}
