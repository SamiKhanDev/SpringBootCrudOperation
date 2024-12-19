package com.example.employeeDemo.service;


import com.example.employeeDemo.entity.Employee;
import com.example.employeeDemo.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl {
    @Autowired
    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }


    public Optional<Employee> findById(int theId) {
        return employeeRepository.findById(theId);
    }


    public Employee saveEmployee(Employee theEmployee) {
        return employeeRepository.save(theEmployee);
    }

    public Employee updateEmployee(Employee theEmployee,int id){
        return employeeRepository.findById(id).map(
                employee -> {
                employee.setFirstname(employee.getFirstname());
                employee.setLastName(employee.getLastName());
                employee.setEmail(employee.getEmail());
               return employeeRepository.save(theEmployee);

                }).orElseThrow(()-> new RuntimeException("couldn't find the employee in table"));
    }


    public void deleteById(int theId) {
        employeeRepository.deleteById(theId);

    }


    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }
}
