package com.satishlabs.springboot.course.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.satishlabs.springboot.course.Course;

@Repository
public class CourseJdbcRepository {
	@Autowired
	private JdbcTemplate springJdbcTemplate;
	
	/*
	 * private static String INSERT_QUERY = """ insert into course(id,name,author)
	 * values(1,'Learn-AWS','Satish'); """; public void insert() {
	 * springJdbcTemplate.update(INSERT_QUERY); }
	 */
	
	private static String INSERT_QUERY = 
			"""
					insert into course(id,name,author)
					values(?,?,?);
			""";
	

	private static String SELECT_QUERY = 
			"""
					select * from course
					where id=?
			""";
	
	private static String DELETE_QUERY = 
			"""
					delete from course
					where id=?
			""";
	
	public void insert(Course course) {
		springJdbcTemplate.update(INSERT_QUERY,course.getId(),course.getName(),course.getAuthor());
	}
	
	public Course selectById(long id) {
		return springJdbcTemplate.queryForObject(SELECT_QUERY,new BeanPropertyRowMapper<>(Course.class), id);
		//ResultSet  -> Bean =>Row Mapper
		//id
		
	}
	
	public void deleteById(long id) {
		springJdbcTemplate.update(DELETE_QUERY,id);
	}
}
