package com.codewithsai.springcrudrest.rest;

import com.codewithsai.springcrudrest.entity.Employee;
import com.codewithsai.springcrudrest.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeRestController(EmployeeService employeeService){
        this.employeeService=employeeService;
    }
    @GetMapping("/employee")
    public List<Employee> fetchEmployees(){
        return employeeService.findAll();
    }


    @GetMapping("/employee/{employeeId}")
    public Employee fetchEmployeeById(@PathVariable int employeeId){
        Employee employee=employeeService.findById(employeeId);
        return employee;
    }

    @PostMapping("/employee")
    public Employee createEmployee(@RequestBody Employee employee){
        employee.setId(0);
        return  employeeService.save(employee);
    }

    @PutMapping("/employee")
    public Employee updateEmployee(@RequestBody Employee employee){
        Employee employee1=employeeService.save(employee);
        return employee1;
    }

    @DeleteMapping("employee/{employeeId}")
    public void deleteEmployee(@PathVariable int employeeId){
        employeeService.deleteById(employeeId);
    }

}
