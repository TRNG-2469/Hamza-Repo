package com.week1.day3;

public class Car extends Vehicle implements Driveable {
    public Car(String model) {
        super(model);
    }

    @Override
    public void start() {
        System.out.println("The car is starting.");
    }

    @Override
    public void accelerate() {
        Car.super.speed += 20;
        System.out.println("The car is accelerating. Current speed: " + speed + " km/h");
    }

    @Override
    public void soundHorn() {
        Driveable.super.soundHorn();
    }
}