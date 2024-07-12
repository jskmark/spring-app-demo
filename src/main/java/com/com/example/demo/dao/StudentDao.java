package com.example.demo.dao;

import java.util.List;

import com.example.demo.bean.Student;

public interface StudentDao {
	void save(Student theStudent);
	Student findById(int id);
	List<Student> getAllStudents();
	void updateStudent(Student theStudent);
	int deleteStudentByName(String sname);
	void deleteStudentById(Student student);
}
