package com.week1.day3;

public abstract class Vehicle {
    protected String model;
    protected double speed;

    //Constructor
    public Vehicle(){}
    public Vehicle(String model) {
        this.model = model;
        this.speed = 0.0;
    }
    public abstract void start();
    public void stop() {
        this.speed = 0.0;
        System.out.println(model + " has stopped.");
    }
}
