package com.rev.sp.boot.sp.service;

import com.rev.sp.boot.sp.model.Employee;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class EmployeeService {
    private List<Employee> employees = new ArrayList<>(Arrays.asList(

            new Employee(101, "Rahul Sharma", "rahul.sharma@example.com", "IT", "Developer", 60000),
            new Employee(102, "Priya Singh", "priya.singh@example.com", "HR", "Manager", 75000),
            new Employee(103, "Amit Verma", "amit.verma@example.com", "IT", "Tester", 55000),
            new Employee(104, "Sneha Patel", "sneha.patel@example.com", "Finance", "Accountant", 60000),
            new Employee(105, "Arjun Mehta", "arjun.mehta@example.com", "IT", "Manager", 90000),
            new Employee(106, "Neha Gupta", "neha.gupta@example.com", "HR", "Recruiter", 45000)
    ));
    public List<Employee> getAllEmployees() {
        return employees;
    }
    public Employee getEmployeeById(@PathVariable int id) {
        for (Employee employee : employees) {
            if (employee.getId() == id) {
                return employee;
            }
        }
        return null; // or throw an exception if employee not found
    }
    public Employee createEmployee(@RequestBody Employee employee) {
        employees.add(employee);
        return employee;
    }

    public Employee updateEmployee(@PathVariable int id, @RequestBody Employee updatedEmployee) {
        for (int i = 0; i < employees.size(); i++) {
            Employee employee = employees.get(i);
            if (employee.getId() == id) {
                employee.setName(updatedEmployee.getName());
                employee.setEmail(updatedEmployee.getEmail());
                employee.setDepartment(updatedEmployee.getDepartment());
                employee.setDesignation(updatedEmployee.getDesignation());
                employee.setSalary(updatedEmployee.getSalary());
                return updatedEmployee;
            }
        }
        return null; // or throw an exception if employee not found
    }

    public String deleteEmployee(@PathVariable int id) {
        for (int i = 0; i < employees.size(); i++) {
            Employee employee = employees.get(i);
            if (employee.getId() == id) {
                employees.remove(i);
                return "Employee with ID " + id + " deleted.";
            }
        }
        return "Employee with ID " + id + " not found.";
    }

    public Employee getEmployeeByEmail(@PathVariable String email) {
        for (Employee employee : employees) {
            if (employee.getEmail().equalsIgnoreCase(email)) {
                return employee;
            }
        }
        return null; // or throw an exception if employee not found
    }

    public List<Employee> getEmployeesByDepartment(@PathVariable String department) {
        List<Employee> departmentEmployees = new ArrayList<>();
        for (Employee employee : employees) {
            if (employee.getDepartment().equalsIgnoreCase(department)) {
                departmentEmployees.add(employee);
            }
        }
        return departmentEmployees;
    }

    public List<Employee> getEmployeesByDesignation(@RequestParam String designation) {
        List<Employee> designationEmployees = new ArrayList<>(); for (Employee employee : employees) {
            if (employee.getDesignation().equalsIgnoreCase(designation)) {
                designationEmployees.add(employee);
            }
        }
        return designationEmployees;
    }

    public List<Employee> getEmployeesBySalaryRange(@RequestParam double minSalary, @RequestParam double maxSalary) {
        List<Employee> salaryRangeEmployees = new ArrayList<>();
        for (Employee employee : employees) {
            if (employee.getSalary() >= minSalary && employee.getSalary() <= maxSalary) {
                salaryRangeEmployees.add(employee);
            }
        }
        return salaryRangeEmployees;
    }

}
