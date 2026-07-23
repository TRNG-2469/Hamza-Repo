package com.week1.day3;

public class GarageApp {
    public static void main(String[] args) {
        Car car = new Car("Toyota");
        Truck truck = new Truck("Ford");

        car.start();
        car.accelerate();
        car.soundHorn();
        car.stop();

        System.out.println();

        truck.start();
        truck.accelerate();
        truck.soundHorn();
        truck.stop();
    }
}
