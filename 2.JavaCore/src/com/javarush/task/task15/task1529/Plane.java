package com.javarush.task.task15.task1529;

public class Plane implements CanFly {
    private int countPassengers;

    @Override
    public void fly() {

    }

    public Plane(int countPassengers) {
        this.countPassengers = countPassengers;
    }
}
