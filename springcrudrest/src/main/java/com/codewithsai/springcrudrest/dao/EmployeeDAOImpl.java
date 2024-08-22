package com.codewithsai.springcrudrest.dao;

import com.codewithsai.springcrudrest.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOImpl implements  EmployeeDAO{

    private EntityManager entityManager;

    @Autowired
    public EmployeeDAOImpl(EntityManager entityManager){
        this.entityManager=entityManager;
    }

    @Override
    public Employee save(Employee e) {

        Employee employee=entityManager.merge(e);
        return employee;
    }

    @Override
    public List<Employee> findAll() {
        TypedQuery<Employee> typedQuery=entityManager.createQuery("from Employee",Employee.class);
        List<Employee> employees=typedQuery.getResultList();
        return employees;
    }

    @Override
    public Employee findById(Integer id) {
        Employee employee=entityManager.find(Employee.class,id);
        return employee;
    }

    @Override
    public void deleteById(Integer id) {
        Employee employee=entityManager.find(Employee.class,id);
        entityManager.remove(employee);
    }
}
