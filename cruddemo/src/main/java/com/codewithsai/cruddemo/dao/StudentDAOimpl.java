package com.codewithsai.cruddemo.dao;

import com.codewithsai.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentDAOimpl implements  StudentDAO{

    //define entityManager
    private EntityManager entityManager;

    @Autowired
    public StudentDAOimpl(EntityManager entityManager){
        this.entityManager=entityManager;
    }
    @Transactional
    @Override
    public void save(Student s) {
        entityManager.persist(s);
    }

    @Override
    public List<Student> findAll() {
        TypedQuery<Student >typedQuery=entityManager.createQuery("FROM Student order by lastName",Student.class);
        return typedQuery.getResultList();
    }

    @Override
    public List<Student> findAllByLastName(String lastName) {
        TypedQuery<Student >typedQuery=entityManager.createQuery("from Student where lastName=:theData",Student.class);
        typedQuery.setParameter("theData",lastName);
        return typedQuery.getResultList();
    }

    @Override
    public Student findById(Integer id) {
       return entityManager.find(Student.class,id);
    }

    @Override
    @Transactional
    public void update(Student student) {
        entityManager.merge(student);
    }

    @Override
    @Transactional
    public void remove(Student s,Integer id) {
        Student student=entityManager.find(Student.class,id);
        entityManager.remove(student);
    }

    @Override
    @Transactional
    public int removeAllStudents() {
        int numOfrowsDelted=entityManager.createQuery("delete from Student").executeUpdate();
        return numOfrowsDelted;
    }
}
