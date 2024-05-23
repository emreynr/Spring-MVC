package com.spring.springmvccrudproject.controller;

import com.spring.springmvccrudproject.entity.Employee;
import com.spring.springmvccrudproject.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    // project structure:
    // EmployeeController <--> EmployeeService <--> EmployeeRepository <--> Database

    // we created CRUD methods for employees. Get a reference for service class if you want use the service
    private EmployeeService employeeService;

    // constructor
    @Autowired
    public EmployeeController(EmployeeService theEmployeeService) {
        employeeService = theEmployeeService;
    }

    //
    // endpoint
    //

    // "list" endpoint for getting all employees
    @GetMapping("/list")
    public String listAllEmployees(Model theModel) {

        // access to db and get all of employees
        List<Employee> allEmployees = employeeService.findAll();

        // for thymeleaf, you need a model for using that
        theModel.addAttribute("allEmployees", allEmployees);

        return "list-employees";
    }

    @GetMapping("/ShowFormForAdd")
    public String showFormForAdd(Model theModel) {

        // create an employee from Employee class
        Employee theEmployee = new Employee();

        theModel.addAttribute("allEmployees", theEmployee);

        return "employee-form";
    }

    // save Employee
    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("allEmployees") Employee theEmployee) { // model name: allEmployees

        // save the employee
        employeeService.saveEmployee(theEmployee);

        // returning to list. Need to restrict for duplicate values
        return "redirect:/employees/list";
    }

    // update an employee
    @GetMapping("/ShowFormForUpdate")
    public String showFormForUpdate(@RequestParam("employeeId") int theId, Model theModel) {

        // get an employee from service methods
        Employee getEmployee = employeeService.findById(theId);

        // add to model attribute
        theModel.addAttribute("allEmployees", getEmployee);

        // return form
        return "employee-form";
    }

    // delete an employee
    @GetMapping("/ShowFormForDelete")
    public String deleteEmployee(@RequestParam("employeeId") int theId) {

        // delete employee
        employeeService.deleteById(theId);

        // redirect to employee-list after delete action
        return "redirect:/employees/list";
    }
}