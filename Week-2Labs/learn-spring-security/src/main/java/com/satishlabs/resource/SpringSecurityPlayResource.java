package com.satishlabs.resource;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.jdbc.JdbcDaoImpl;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class SpringSecurityPlayResource {

	@GetMapping("/csrf-token")
	public CsrfToken retriveCsrfToken(HttpServletRequest request) {
		return (CsrfToken) request.getAttribute("_csrf");
	}

	/*
	 * @Bean public UserDetailsService userDetailsService() { var user =
	 * User.withUsername("satishlabs") .password("{noop}dummy") .roles("USER")
	 * .build();
	 * 
	 * var admin = User.withUsername("admin") .password("{noop}dummy")
	 * .roles("ADMIN") .build();
	 * 
	 * return new InMemoryUserDetailsManager(user,admin); }
	 */

	@Bean
	public DataSource dataSource() {
		return new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.H2)
				.addScript(JdbcDaoImpl.DEFAULT_USER_SCHEMA_DDL_LOCATION).build();
	}

	@Bean
	public UserDetailsService userDetailsService(DataSource dataSource) {
		var user = User.withUsername("satishlabs")
				// .password("{noop}dummy")
				.password("dummy").passwordEncoder(str -> passwordEncoder().encode(str)).roles("USER").build();

		var admin = User.withUsername("admin")
				// .password("{noop}dummy")
				.password("dummy").passwordEncoder(str -> passwordEncoder().encode(str)).roles("ADMIN", "USER").build();

		var jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);
		jdbcUserDetailsManager.createUser(user);
		jdbcUserDetailsManager.createUser(admin);

		return jdbcUserDetailsManager;
	}

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
