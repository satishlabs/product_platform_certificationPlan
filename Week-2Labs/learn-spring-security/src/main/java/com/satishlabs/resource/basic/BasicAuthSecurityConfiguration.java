package com.satishlabs.resource.basic;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableMethodSecurity(jsr250Enabled = true,securedEnabled = true)
public class BasicAuthSecurityConfiguration {

	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests(
				auth -> {
						auth
						.requestMatchers("/users").hasRole("USER")
						.requestMatchers("/admin/**").hasRole("ADMIN")
						.anyRequest().authenticated();
					});
		http.sessionManagement(session ->{
			session.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		});
		//http.formLogin();
		http.httpBasic();
		http.csrf().disable();
		
		http.headers().frameOptions().sameOrigin();
		
		//http.oauth2ResourceServer(OAuth2ResourceServerConfigurer::jwt);
		
		return http.build();
	}
}
