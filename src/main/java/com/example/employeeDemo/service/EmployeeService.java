package com.example.employeeDemo.service;

import com.example.employeeDemo.entity.Employee;

import java.util.List;

public interface EmployeeService {
    Employee findById(int theId);
    Employee saveEmployee(Employee theEmployee);
    void deleteById(int theId);
    List<Employee> findAll ();
}
