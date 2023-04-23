package com.satishlabs.resource.jwt;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.interfaces.RSAPublicKey;
import java.util.UUID;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.oauth2.server.resource.OAuth2ResourceServerConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.jwk.JWKSet;
import com.nimbusds.jose.jwk.RSAKey;
import com.nimbusds.jose.jwk.source.JWKSource;
import com.nimbusds.jose.proc.SecurityContext;

//@Configuration
public class JwtSecurityConfiguration {

	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests(
				auth -> {
						auth.anyRequest().authenticated();
					});
		http.sessionManagement(session ->{
			session.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		});
		//http.formLogin();
		http.httpBasic();
		http.csrf().disable();
		
		http.headers().frameOptions().sameOrigin();
		
		http.oauth2ResourceServer(OAuth2ResourceServerConfigurer::jwt);
		
		return http.build();
	}
	
	@Bean
	public KeyPair keyPair() {
		try {
		var keyPairGenerator =	KeyPairGenerator.getInstance("RSA");
		keyPairGenerator.initialize(2048);
		return keyPairGenerator.generateKeyPair();
		}catch (Exception ex) {
			throw new RuntimeException(ex);
		}
	}
	
	@Bean
	public RSAKey raKey(KeyPair keyPair) {
		return new RSAKey
			.Builder((RSAPublicKey)keyPair.getPublic())
			.privateKey(keyPair.getPrivate())
			.keyID(UUID.randomUUID().toString())
			.build();
	}
	
	@Bean
	public JWKSource<SecurityContext> jwkSource(RSAKey raKey) {
		var jwkSet =new JWKSet(raKey);
		return (jwkSelector, context)->jwkSelector.select(jwkSet);
	}
	
	@Bean
	public JwtDecoder jwtDecoder(RSAKey raKey) throws JOSEException {
		return NimbusJwtDecoder
				.withPublicKey(raKey.toRSAPublicKey())
				.build();
	}
	
	@Bean
	public JwtEncoder jwtEncoder(JWKSource<SecurityContext> jwkSource) {
		return new NimbusJwtEncoder(jwkSource);
	}
}
