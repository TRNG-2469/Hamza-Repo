package com.rev.week1;

public class EmployeeProfile {
    private String employeeId;
    private String name;
    private double monthlySalary;

    public EmployeeProfile(String employeeId, String name, double salary) {
        this.employeeId = employeeId;
        setName(name);
        setMonthlySalary(salary);
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null) {
            System.err.println("Error: Name is invalid. Value not changed.");
        } else {
            this.name = name;
        }
    }

    public double getMonthlySalary() {
        return monthlySalary;
    }

    public void setMonthlySalary(double monthlySalary) {
        if (monthlySalary >= 0.0) {
            this.monthlySalary = monthlySalary;
        } else {
            System.err.println("Error: monthly salary must be >= 0.0. Value not changed.");
        }
    }
}