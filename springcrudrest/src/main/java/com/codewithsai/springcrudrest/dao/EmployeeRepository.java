package com.codewithsai.springcrudrest.dao;

import com.codewithsai.springcrudrest.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
}
