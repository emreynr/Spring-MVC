package com.spring.springmvccrudproject.service;

import com.spring.springmvccrudproject.dao.EmployeeRepository;
import com.spring.springmvccrudproject.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    // jparepository ile kullanabilmek icin oncelikle referansi olusturulmali
    private EmployeeRepository employeeRepository;

    // contructor for jpa repository
    @Autowired
    public EmployeeServiceImpl(EmployeeRepository theEmployeeRepository) {
        employeeRepository = theEmployeeRepository;
    }


    @Override
    public void saveEmployee(Employee theEmployee) {
        employeeRepository.save(theEmployee);
    }


    @Override
    public Employee findById(int employeeId) {
        Optional<Employee> result = employeeRepository.findById(employeeId);
        Employee employee = null;

        if (result.isPresent()) {
            employee = result.get();
        }
        else {
            throw new RuntimeException("the employee didnt found with provided id : " + employeeId);
        }
        return employee;
    }


    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAllByOrderByFirstNameAsc();
    }


    @Override
    public void updateEmployee(Employee theEmployee) {
        employeeRepository.save(theEmployee);
    }


    @Override
    public void deleteById(int employeeId) {
        employeeRepository.deleteById(employeeId);
        System.out.println("deleted id : " + employeeId);
    }
}
