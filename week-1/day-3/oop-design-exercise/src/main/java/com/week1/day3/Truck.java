package com.week1.day3;

public class Truck extends Vehicle implements Driveable{
    public Truck(String model) {
        super(model);
    }

    @Override
    public void start() {
        System.out.println("The truck is starting.");
    }

    @Override
    public void accelerate() {
        Truck.super.speed += 10;
        System.out.println("The truck is accelerating. Current speed: " + speed + " km/h");
    }

    @Override
    public void soundHorn() {
        Driveable.super.soundHorn();
    }
}
