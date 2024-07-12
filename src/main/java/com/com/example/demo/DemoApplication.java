package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.bean.Student;
import com.example.demo.dao.StudentDao;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		//System.setProperty("spring.config.name", "application.properties");
		SpringApplication.run(DemoApplication.class, args);
	}
	
//	@Bean
//	CommandLineRunner commandLineRunner(StudentDao studentDao) {
//		return runner -> {
//			createStudent(studentDao);
//		};
//	}
	
}
