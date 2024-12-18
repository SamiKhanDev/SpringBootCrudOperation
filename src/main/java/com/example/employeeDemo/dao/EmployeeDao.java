package com.example.employeeDemo.dao;

import com.example.employeeDemo.entity.Employee;

import java.util.List;

public interface EmployeeDao {
    Employee findById(int theId);
    Employee saveEmployee(Employee theEmployee);
    void deleteById(int theId);
    List<Employee> findAll();
}
