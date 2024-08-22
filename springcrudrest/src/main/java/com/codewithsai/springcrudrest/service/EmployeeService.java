package com.codewithsai.springcrudrest.service;

import com.codewithsai.springcrudrest.entity.Employee;
import org.springframework.stereotype.Service;

import java.util.List;


public interface EmployeeService {

    Employee save(Employee e);
    List<Employee> findAll();
    Employee findById(Integer id);
    void deleteById(Integer id);
}
