package com.satishlabs.springboot;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseController {
	
	@GetMapping("/courses")
	public List<Course> retirveAllCourses(){
		return Arrays.asList(
				new Course(1,"Learn Spring Boot","satishlabs"),
				new Course(2,"Learn AWS","Intuit"),
				new Course(3,"Microservices","Altimetrik")
				);
	}
}
