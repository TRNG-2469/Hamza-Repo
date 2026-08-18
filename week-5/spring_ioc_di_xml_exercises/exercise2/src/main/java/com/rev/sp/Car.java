package com.rev.sp;

public class Car {
    private int price;
    private String model;
    private Engine engine;

    public Car(Engine engine) {
        this.engine = engine;
    }
    public int getPrice() {
        return 1500000;
    }

    public String getModel() {
        return "Honda City";
    }
    public int getHorsePower() {
        return engine.getHorsePower();
    }
}

