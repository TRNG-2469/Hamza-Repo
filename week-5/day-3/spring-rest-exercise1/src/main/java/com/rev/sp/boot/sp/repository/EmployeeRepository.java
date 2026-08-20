package com.rev.sp.boot.sp.repository;

import com.rev.sp.boot.sp.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface EmployeeRepository  extends JpaRepository<Employee, Integer> {

    List<Employee> getAllEmployees();
    Employee getEmployeeById(int id);
    Employee getEmployeeByEmail( String email);
    Employee getEmployeeByName( String name);
    Employee getEmployeeBySalary(double salary);

    List<Employee> getEmployeesByDepartment(String department);
    List<Employee> getEmployeesByDesignation(@RequestParam String designation);
    @Query("SELECT e FROM Employee e WHERE e.salary >= :min AND e.salary <= :max")
    List<Employee> getEmployeesBySalaryRange(double minSalary,double maxSalary);
}
