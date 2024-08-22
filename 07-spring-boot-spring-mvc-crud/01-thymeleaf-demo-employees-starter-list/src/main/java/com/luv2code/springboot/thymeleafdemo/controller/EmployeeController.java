package com.luv2code.springboot.thymeleafdemo.controller;

import com.luv2code.springboot.thymeleafdemo.entity.Employee;
import com.luv2code.springboot.thymeleafdemo.service.EmployeeService;
import com.luv2code.springboot.thymeleafdemo.service.EmployeeServiceImpl;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

	// load employee data
	private  EmployeeService theEmployeeService;

	@Autowired
	public EmployeeController(EmployeeService employeeService){
		theEmployeeService=employeeService;
	}

	private List<Employee> theEmployees;
	@PostMapping("/employee")
	public String createEmployee(@RequestBody Employee employee){
			theEmployeeService.save(employee);
			return "helloworld";
	}


	// add mapping for "/list"

	@GetMapping("/list")
	public String listEmployees(Model theModel) {

		List<Employee> theEmployees=theEmployeeService.findAll();
		// add to the spring model
		theModel.addAttribute("employees", theEmployees);

		return "employees/list-employees";
	}

    @GetMapping("/showFormToAdd")
    public String addEmployee(Model model){
        Employee employee=new Employee();
        model.addAttribute("employee",employee);
        return "employees/new-form";
    }

	@PostMapping("/save")
	public String saveEmployee(@ModelAttribute("employee") Employee employee){
		theEmployeeService.save(employee);

		return "redirect:/employees/list";
	}

	@GetMapping("/showFormToUpdate")
	public String updateEmployee(@RequestParam("employeeId") Integer id,Model model){
		Employee employee=theEmployeeService.findById(id);
		model.addAttribute("employee",employee);
		return "employees/new-form";
	}

	@GetMapping("delete")
	public String deleteEmployee(@RequestParam("employeeId") Integer id){
//		Employee employee=theEmployeeService.findById(id);
		theEmployeeService.deleteById(id);
		return "redirect:/employees/list";
	}

}









