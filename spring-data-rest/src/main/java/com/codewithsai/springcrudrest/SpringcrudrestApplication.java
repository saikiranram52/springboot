package com.codewithsai.springcrudrest;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringcrudrestApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringcrudrestApplication.class, args);
	}

//	@Bean
//	public CommandLineRunner commandLineRunner(EmployeeDAO employee){
//		return runner->{
////			createEmployee(employee);
////			fetchEmployees(employee);
//		};
//	}
//
//	public void createEmployee(EmployeeDAO employeeDAO){
//		Employee emp=new Employee("sai","kiran","@gmail.com");
//		employeeDAO.save(emp);
//		System.out.println("yes");
//		return;
//	}
//
//	public void fetchEmployees(EmployeeDAO employeeDAO){
//		List<Employee> employeeList=employeeDAO.findAll();
//		for(Employee e:employeeList){
//			System.out.println(e.toString());
//		}
//	}

}
