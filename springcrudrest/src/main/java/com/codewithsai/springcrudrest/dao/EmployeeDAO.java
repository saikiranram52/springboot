package com.codewithsai.springcrudrest.dao;

import com.codewithsai.springcrudrest.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    Employee save(Employee e);
    List<Employee> findAll();
    Employee findById(Integer id);
    void deleteById(Integer id);
}
