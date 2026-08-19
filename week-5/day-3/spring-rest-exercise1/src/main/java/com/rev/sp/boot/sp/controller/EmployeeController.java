package com.rev.sp.boot.sp.controller;

import com.rev.sp.boot.sp.model.Employee;
import com.rev.sp.boot.sp.service.EmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController("api/v1")
@RequestMapping
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public ResponseEntity<List<Employee>> getAllEmployees() {
        List<Employee> employees = employeeService.getAllEmployees();
        return ResponseEntity.ok(employees);
    }

    @GetMapping("/employees/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable int id) {
        Employee employee = employeeService.getEmployeeById(id);
        if (employee != null) {
            return ResponseEntity.ok(employee);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/employees")
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
        Employee createdEmployee = employeeService.createEmployee(employee);
        return ResponseEntity.status(201).body(createdEmployee);
    }
    @PutMapping("/employees/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable int id, @RequestBody Employee updatedEmployee) {
        Employee employee = employeeService.updateEmployee(id, updatedEmployee);
        if (employee != null) {
            return ResponseEntity.ok(employee);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/employees/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable int id) {
        String result = employeeService.deleteEmployee(id);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/employees/email/{email}")
    public ResponseEntity<Employee> getEmployeeByEmail(@PathVariable String email) {
        Employee employee = employeeService.getEmployeeByEmail(email);
        if (employee != null) {
            return ResponseEntity.ok(employee);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/employees/department/{department}")
    public ResponseEntity<List<Employee>> getEmployeesByDepartment(@PathVariable String department) {
        List<Employee> employees = employeeService.getEmployeesByDepartment(department);
        return ResponseEntity.ok(employees);
    }

    @GetMapping("/employees")
    public ResponseEntity<List<Employee>> getEmployeesByDesignation(@RequestParam String designation) {
        List<Employee> employees = employeeService.getEmployeesByDesignation(designation);
        return ResponseEntity.ok(employees);
    }

    @GetMapping("/employees/salary")
    public ResponseEntity<List<Employee>> getEmployeesBySalaryRange(@RequestParam double minSalary, @RequestParam double maxSalary) {
        List<Employee> employees = employeeService.getEmployeesBySalaryRange(minSalary, maxSalary);
        return ResponseEntity.ok(employees);
    }

}
