package com.spring.springmvccrudproject.dao;

import com.spring.springmvccrudproject.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    // need to access database and JPA will be fix that for us.
    // JPA has many methods already. Do not need write that methods again. Just implement and use.

    public List<Employee> findAllByOrderByFirstNameAsc();

}
