package com.example.demo.daoimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.bean.Student;
import com.example.demo.dao.StudentDao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Repository
public class StudentDaoImpl implements StudentDao {

	private EntityManager entityManager;
	
	@Autowired
	public StudentDaoImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	@Override
	@Transactional
	public void save(Student theStudent) {
		// TODO Auto-generated method stub
		entityManager.persist(theStudent);
	}

	@Override
	public Student findById(int id) {
		// TODO Auto-generated method stub
		
		return entityManager.find(Student.class, id);
	}

	@Override
	public List<Student> getAllStudents() {
		TypedQuery<Student> studentQuery = entityManager.createQuery("from Student order by sname", Student.class);
		return studentQuery.getResultList();
	}

	@Override
	@Transactional
	public void updateStudent(Student theStudent) {
		// TODO Auto-generated method stub
		entityManager.merge(theStudent);
	}

	@Override
	@Transactional
	public int deleteStudentByName(String sname) {
		// TODO Auto-generated method stub
		return entityManager.createQuery("delete from Student where sname = '"+sname+"'").executeUpdate();
	}

	@Override
	@Transactional
	public void deleteStudentById(Student student) {
		// TODO Auto-generated method stub
		entityManager.remove(student);
	}
}
