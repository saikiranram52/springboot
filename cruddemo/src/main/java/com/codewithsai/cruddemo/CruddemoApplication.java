package com.codewithsai.cruddemo;

import com.codewithsai.cruddemo.dao.StudentDAO;
import com.codewithsai.cruddemo.dao.StudentDAOimpl;
import com.codewithsai.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO student){
		return runner->{
			createStudent(student);

//			readStudent(student);

			//Query all the students
//			readAll(student);

			//Query all the students by lastName
//			readAllBylastName(student);

			//update a student
//			update(student);

			//delete a student
//			deleteStudent(student);

			//delete all students
//			deleteAllStudents(student);
		};
	}

	public void createStudent(StudentDAO student){
		//create student object
		System.out.println("creating the student object");
		Student s=new Student("sai","iran","saikiranram52@gmail.com");

		System.out.println("saving the student object");

		//save the student object
		student.save(s);

//		System.out.println("student is saved with id"+s.getId());

		Student studentById=student.findById(s.getId());

		//Displaying the student details
		System.out.println("Student details :  "+studentById);
	}

	public void readStudent(StudentDAO student){
		System.out.println("creating the student object");
		Student s=new Student("sushma","ram","sushma1@gmail.com");

		System.out.println("saving the student object");

		//save the student object
		student.save(s);

		//Display the ID of the student
		System.out.println("student is saved with id:  "+s.getId());

		//Find the Student by ID
		Student studentById=student.findById(s.getId());

		//Displaying the student details
		System.out.println("Student details :  "+studentById);
	}

	public void readAll(StudentDAO student){
		List<Student> listOfStudents=student.findAll();
		for(Student s:listOfStudents){
			System.out.println(s);
		}
	}

	public void readAllBylastName(StudentDAO studentDAO){
		List<Student> listOfStudents= studentDAO.findAllByLastName("ram");
		for(Student s:listOfStudents){
			System.out.println(s);
		}
	}

	private void update(StudentDAO studentDAO){
		//find the student by id
		int id=1;
		System.out.println("finding the student by id :  "+id);
		Student student=studentDAO.findById(id);

		//change the firstname of the student
		System.out.println("change the firstName of the student to: "+"sampath");
		student.setFirstName("sampath");

		//update the student
		System.out.println("updating the student");
		studentDAO.update(student);

		//display the updated student
		System.out.println("Updated student: "+student);
	}

	private void deleteStudent(StudentDAO studentDAO){
		 EntityManager entityManager;
		//find the student by id
		int id=2;
		System.out.println("finding the student by id :  "+id);
		Student student=studentDAO.findById(id);

		//remove student
		System.out.println("removing the student with id: "+id);
		studentDAO.remove(student,id);

		System.out.println("student removed successfully");

	}

	private  void deleteAllStudents(StudentDAO studentDAO){
		//deleting all the rows
		int noOfrows=studentDAO.removeAllStudents();
		System.out.println("delted "+noOfrows+" rows");

	}


}
