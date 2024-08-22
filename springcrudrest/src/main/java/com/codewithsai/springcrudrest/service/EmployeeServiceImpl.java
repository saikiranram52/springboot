package com.codewithsai.springcrudrest.service;

import com.codewithsai.springcrudrest.dao.EmployeeDAO;
import com.codewithsai.springcrudrest.dao.EmployeeDAOImpl;
import com.codewithsai.springcrudrest.dao.EmployeeRepository;
import com.codewithsai.springcrudrest.entity.Employee;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements  EmployeeService{

    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository){
        this.employeeRepository=employeeRepository;
    }

    @Transactional
    @Override
    public Employee save(Employee e) {

        Employee employee=employeeRepository.save(e);
        return employee;
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(Integer id) {
        Optional <Employee> result=employeeRepository.findById(id);

        Employee employee=null;

        if(result.isPresent()){
            employee=result.get();
        }
        else{
            throw new RuntimeException("Id not found: "+id);
        }
        return employee;
    }

    @Override
    public void deleteById(Integer id) {
        employeeRepository.deleteById(id);
    }
}
