package com.rev.sp.boot.sp.service;

import com.rev.sp.boot.sp.model.Employee;
import com.rev.sp.boot.sp.repository.EmployeeRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee getEmployeeById(@PathVariable int id) {
        return employeeRepository.findById(id).orElse(null);
    }
    public Employee createEmployee(@RequestBody Employee employee) {
        return employeeRepository.save(employee);
    }

    public Employee updateEmployee(@PathVariable int id, @RequestBody Employee updatedEmployee) {
        Employee existingEmployee = employeeRepository.findById(id).orElse(null);
        if (existingEmployee != null) {
            // Update the properties of existingEmployee with those from updatedEmployee
            return employeeRepository.save(existingEmployee);
        }
        return null;
    }

    public String deleteEmployee(@PathVariable int id) {
        employeeRepository.deleteById(id);
        return "Employee deleted successfully";
    }

    public Employee getEmployeeByEmail(@PathVariable String email) {
        return employeeRepository.getEmployeeByEmail(email);
    }

    public List<Employee> getEmployeesByDepartment(@PathVariable String department) {
        return employeeRepository.getEmployeesByDepartment(department);
    }

    public List<Employee> getEmployeesByDesignation(@RequestParam String designation) {
        return employeeRepository.getEmployeesByDesignation(designation);
    }

    public List<Employee> getEmployeesBySalaryRange(@RequestParam double minSalary, @RequestParam double maxSalary) {
        return employeeRepository.getEmployeesBySalaryRange(minSalary, maxSalary);
    }

}
