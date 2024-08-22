package com.codewithsai.cruddemo.dao;

import com.codewithsai.cruddemo.entity.Student;

import java.util.List;

public interface StudentDAO  {
    void save(Student s);
    List<Student> findAll();
    List<Student> findAllByLastName(String s);
    Student findById(Integer  id);
    void update(Student s);
    void remove(Student s,Integer id);
    int removeAllStudents();
}
