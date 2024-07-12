package com.example.demo;

import java.util.List;

import com.example.demo.bean.Student;
import com.example.demo.dao.StudentDao;
import com.example.demo.daoimpl.StudentDaoImpl;

public class StudentDB {
	
	public int createStudent(StudentDao studentDao ,Student studentObject) {
		// TODO Auto-generated method stub
		Student tempStudent = new Student(studentObject.getAge(), studentObject.getRollno(), studentObject.getSname());
		studentDao.save(tempStudent);
		System.out.println("The student object written successfully!! and ID is "+tempStudent.getId());
		return tempStudent.getId();
	}

	public Student retrieveStudent(StudentDao studentDao, int id) {
		return studentDao.findById(id);
	}
	
	public List<Student> getAllStudents(StudentDao studentDao) {
		return studentDao.getAllStudents();
	}
	
	public Student updateStudent(StudentDao studentDao, Student student, int id) {
		Student studentM = studentDao.findById(id);
		studentM.setAge(student.getAge());
		studentM.setRollno(student.getRollno());
		studentM.setSname(student.getSname());
		studentDao.updateStudent(studentM);
		return studentM;
	}
	
	public int removeStudentByName(StudentDao studentDao, String name) {
		return studentDao.deleteStudentByName(name);
	}
	
	public void removeStudentById(StudentDao studentDao, int id) {
		Student student = studentDao.findById(id);
		studentDao.deleteStudentById(student);
	}
}
