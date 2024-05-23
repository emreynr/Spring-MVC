package com.spring.springmvccrudproject.service;

import com.spring.springmvccrudproject.entity.Employee;

import java.util.List;

public interface EmployeeService {

    //
    // CRUD methods
    //

    // Create an Employee
    void saveEmployee(Employee theEmployee);

    // Read an/all Employee
    Employee findById(int employeeId);
    List<Employee> findAll();

    // Update an Employee
    void updateEmployee(Employee theEmployee);

    // Delete and Employee
    void deleteById(int employeeId);


}
