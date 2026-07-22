package com.week1.day3;

/**
 * Base class for all vehicles with common behavior handling.
 */
abstract class Vehicle {
    public abstract String getVehicleType();
    
    public abstract void performAction();
}

class Car extends Vehicle {
    @Override
    public String getVehicleType() {
        return "Car";
    }
    
    @Override
    public void performAction() {
        System.out.println("Car is driving on the road.");
    }
}

class Airplane extends Vehicle {
    @Override
    public String getVehicleType() {
        return "Airplane";
    }
    
    @Override
    public void performAction() {
        System.out.println("Airplane is flying in the sky.");
    }
}

public class AirportApp {
    /**
     * Handles vehicle processing using polymorphism and graceful fallback.
     */
    private static void processVehicle(Vehicle vehicle) {
        if (vehicle == null) {
            System.err.println("Error: Vehicle cannot be null.");
            return;
        }
        
        try {
            System.out.println("Processing vehicle: " + vehicle.getVehicleType());
            vehicle.performAction();
        } catch (Exception e) {
            System.err.println("Error processing vehicle: " + e.getMessage());
        }
    }
    
    public static void main(String[] args) {
        System.out.println("=== Airport Vehicle Management System ===\n");
        
        Vehicle[] vehicles = {
            new Airplane(),
            new Car(),
            new Airplane(),
            null  // Test graceful null handling
        };
        
        for (Vehicle vehicle : vehicles) {
            processVehicle(vehicle);
            System.out.println();
        }
    }
}