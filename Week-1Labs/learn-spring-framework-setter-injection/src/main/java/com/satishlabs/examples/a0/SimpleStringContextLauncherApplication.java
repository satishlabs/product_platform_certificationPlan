package com.satishlabs.examples.a0;

import java.util.Arrays;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;




@Configuration
@ComponentScan
public class SimpleStringContextLauncherApplication {
	
	public static void main(String[] args) {
		try (var ctx = 
				new AnnotationConfigApplicationContext
					(SimpleStringContextLauncherApplication.class)) {
			Arrays.stream(ctx.getBeanDefinitionNames())
					.forEach(System.out::println);
		}

	}
}
