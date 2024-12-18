package com.example.employeeDemo.service;

import com.example.employeeDemo.dao.EmployeeDao;
import com.example.employeeDemo.entity.Employee;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class EmployeeServiceImpl implements EmployeeService{
    private final EmployeeDao employeeDao;

    public EmployeeServiceImpl(EmployeeDao theEmployeeDao){
        employeeDao = theEmployeeDao;


    }

    @Transactional
    @Override
    public Employee findById(int theId) {
        return employeeDao.findById(theId);
    }

    @Transactional
    @Override
    public Employee saveEmployee(Employee theEmployee) {
        return employeeDao.saveEmployee(theEmployee);
    }

    @Transactional
    @Override
    public void deleteById(int theId) {
        employeeDao.deleteById(theId);

    }

    @Override
    public List<Employee> findAll() {
        return employeeDao.findAll();
    }
}
