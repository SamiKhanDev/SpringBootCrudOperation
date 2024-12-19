package com.example.employeeDemo.rest;

import com.example.employeeDemo.entity.Employee;
import com.example.employeeDemo.service.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/employees")
public class EmployeeRestController {
    @Autowired
    private EmployeeServiceImpl employeeServiceImpl;

    @GetMapping
    public List<Employee> findAll(){
        return employeeServiceImpl.findAll();
    }
    @GetMapping("/{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId){
        Optional<Employee> theEmployee = employeeServiceImpl.findById(employeeId);
        throw new RuntimeException("employee id was not found" + employeeId);
    }

    @PostMapping()
    public Employee saveEmployee (@RequestBody Employee employee){
        return employeeServiceImpl.saveEmployee(employee);

    }
    @PutMapping("/{Id}")
    public Employee updateEmployee(@PathVariable int Id, @RequestBody Employee updateEmployee){
        return employeeServiceImpl.updateEmployee(updateEmployee, Id);
    }
    @DeleteMapping("/{Id}")
    public void deleteEmployee(@PathVariable int Id){
        employeeServiceImpl.deleteById(Id);
    }
}
