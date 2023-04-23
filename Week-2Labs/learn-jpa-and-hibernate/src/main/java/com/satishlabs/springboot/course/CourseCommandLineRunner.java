package com.satishlabs.springboot.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.satishlabs.springboot.course.Course;
import com.satishlabs.springboot.course.jdbc.CourseJdbcRepository;
import com.satishlabs.springboot.course.jpa.CourseJpaRepository;
import com.satishlabs.springboot.course.springdatajpa.CourseSpringDataJpaRepository;


@Component
public class CourseCommandLineRunner implements CommandLineRunner {

	//@Autowired
	//private CourseJdbcRepository repository;
	
	//@Autowired
	//private CourseJpaRepository repository;
	
	@Autowired
	private CourseSpringDataJpaRepository repository;

	@Override
	public void run(String... args) throws Exception {
		repository.save(new Course(1, "Learn AWS", "Satish"));
		repository.save(new Course(2, "Learn ReactJS", "Prasad"));
		repository.save(new Course(3, "Learn Microservice", "Test"));
		//courseJdbcRepository.selectById(2);
		System.out.println(repository.findById(2l));
		System.out.println(repository.findById(3l));
		
		
		System.out.println(repository.findAll());
		System.out.println(repository.count());
		
		System.out.println(repository.findByAuthor("Satish"));
		System.out.println(repository.findByAuthor("Prasad"));
		
		System.out.println(repository.findByName("Learn Microservice"));
		
		repository.deleteById(1l);
		
		System.out.println(repository.findByName("Learn AWS"));
		
		
		
		
		
		
	}
}