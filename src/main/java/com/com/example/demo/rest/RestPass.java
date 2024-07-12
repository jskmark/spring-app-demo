package com.example.demo.rest;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.StudentDB;
import com.example.demo.bean.Student;
import com.example.demo.dao.StudentDao;

@RestController
public class RestPass {

	@Autowired
	private StudentDao studentDao;
	
	public RestPass(StudentDao studentDao) {
		this.studentDao = studentDao;
	}
	
	Logger logger = LoggerFactory.getLogger(RestPass.class);
	@GetMapping("/login/{id}/{name}")
	public Login sayHello(@PathVariable int id, @PathVariable String name) {
		Login login = new Login();
		login.setName(name);
		login.setId(id);
		return login;
	}
	
	@GetMapping("/login/response")
	public Login sendResponse(@RequestParam int id, @RequestParam String name) {
		Login login = new Login();
		login.setName(name);
		login.setId(id);
		return login;
	}
	
	@GetMapping(value = "/image",
			  produces = MediaType.IMAGE_PNG_VALUE)
	@ResponseBody
	public byte[] getImage() throws IOException {
		logger.info("Entered inside image retrieval API");
		logger.debug("Entered inside image retrieval API");
		logger.trace("Entered inside image retrieval API");
		logger.warn("Entered inside image retrieval API");
		logger.error("Entered inside image retrieval API");
		InputStream in = getClass().getResourceAsStream("/static/Images/dh.png");
		return IOUtils.toByteArray(in);
	}
	
	@PostMapping("/student/add")
	public Student addStudent(@RequestBody Student theStudent) {
		// TODO Auto-generated method stub
		//Student tempStudent = new Student(4,345,"Quincy clara");
		//studentDao.save(tempStudent);
		StudentDB sdb = new StudentDB();
		int generatedId = sdb.createStudent(studentDao, theStudent);
		//System.out.println("The student object written successfully!! and ID is "+tempStudent.getId());
		theStudent.setId(generatedId);
		return theStudent;
	}
	
	@GetMapping("/student/fetch/{id}")
	public Student retriveStudent(@PathVariable int id) {
		// TODO Auto-generated method stub
		//Student tempStudent = new Student(4,345,"Quincy clara");
		//studentDao.save(tempStudent);
		StudentDB sdb = new StudentDB();
		Student student = sdb.retrieveStudent(studentDao, id);
		//System.out.println("The student object written successfully!! and ID is "+tempStudent.getId());
		return student;
	}
	
	@GetMapping("/student/fetchAll")
	public List<Student> retrieveAllStudent() {
		StudentDB sdb = new StudentDB();
		return sdb.getAllStudents(studentDao);
	}
	
	@PutMapping("/student/update/{id}")
	public Student updateStudent(@PathVariable int id, @RequestBody Student theStudent) {
		StudentDB sdb = new StudentDB();
		return sdb.updateStudent(studentDao, theStudent, id);
	}
	
	@DeleteMapping("/student/delete/name/{name}")
	public int removeStudentByName(@PathVariable String name) {
		StudentDB sdb = new StudentDB();
		return sdb.removeStudentByName(studentDao, name);
	}
	
	@DeleteMapping("/student/delete/id/{id}")
	public void removeStudentById(@PathVariable int id) {
		StudentDB sdb = new StudentDB();
		sdb.removeStudentById(studentDao, id);
	}
	
}
