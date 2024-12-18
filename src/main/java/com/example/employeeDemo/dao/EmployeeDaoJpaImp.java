package com.example.employeeDemo.dao;

import com.example.employeeDemo.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class EmployeeDaoJpaImp implements EmployeeDao{
    private final EntityManager entityManager;
    @Autowired
    public EmployeeDaoJpaImp(EntityManager theEntityManager){
        entityManager = theEntityManager;
    }

    @Override
    public Employee findById(int theId) {
        Employee theEmployee = entityManager.find(Employee.class,theId);
        return theEmployee;
    }

    @Override
    public Employee saveEmployee(Employee theEmployee) {
        Employee dbEmployee = entityManager.merge(theEmployee);

        return dbEmployee;
    }

    @Override
    public void deleteById(int theId) {
        Employee theEmployee= entityManager.find(Employee.class,theId);
        entityManager.remove(theEmployee);

    }

    @Override
    public List<Employee> findAll() {
        TypedQuery<Employee> theQuery = entityManager.createQuery("from Employee", Employee.class);

        return theQuery.getResultList();
    }
}
