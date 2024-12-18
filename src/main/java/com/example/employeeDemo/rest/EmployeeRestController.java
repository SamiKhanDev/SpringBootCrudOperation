package com.example.employeeDemo.rest;

import com.example.employeeDemo.entity.Employee;
import com.example.employeeDemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
    private final EmployeeService employeeService;
    @Autowired
    public EmployeeRestController (EmployeeService theEmployeeService){
       employeeService = theEmployeeService;
    }
    @GetMapping("/employees")
    public List<Employee> findAll(){
        return employeeService.findAll();
    }
    @GetMapping("/employees/{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId){
        Employee theEmployee = employeeService.findById(employeeId);
        if (theEmployee==null){
            throw new RuntimeException("employee id was not found"+ employeeId);
        }
        return theEmployee;
    }
}
