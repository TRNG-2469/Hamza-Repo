package com.rev.sp.boot.sp.model;


import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    private int id;
    @NotBlank(message = "Name cannot be blank.")
    @Size(min = 2, max = 50, message="Name must be a valid size.")
    private String name;
    @NotBlank(message = "Email cannot be blank.")
    @Email(message = "Must enter a valid email.")
    private String email;
    @NotBlank(message = "Department cannot be blank.")
    private String department;
    @NotBlank(message = "Designation cannot be blank.")
    private String designation;
    @Positive(message = "Salary cannot be less than 0.")
    private double salary;
}