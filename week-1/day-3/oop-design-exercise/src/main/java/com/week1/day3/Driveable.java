package com.week1.day3;

public interface Driveable {
    void accelerate();

    default void soundHorn() {
        System.out.println("Beep beep!");
    }
}
