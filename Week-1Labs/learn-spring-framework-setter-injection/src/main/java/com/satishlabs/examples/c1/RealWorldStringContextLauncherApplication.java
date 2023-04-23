package com.satishlabs.examples.c1;

import java.util.Arrays;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;




@Configuration
@ComponentScan
public class RealWorldStringContextLauncherApplication {
	
	public static void main(String[] args) {
		try (var ctx = 
				new AnnotationConfigApplicationContext
					(RealWorldStringContextLauncherApplication.class)) {
			Arrays.stream(ctx.getBeanDefinitionNames())
					.forEach(System.out::println);
			
			System.out.println(ctx.getBean(BusinessCalculationService.class).findMax());
		}

	}
}
