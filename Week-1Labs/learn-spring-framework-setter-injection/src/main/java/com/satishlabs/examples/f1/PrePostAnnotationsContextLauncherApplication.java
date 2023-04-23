package com.satishlabs.examples.f1;

import java.util.Arrays;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;


@Component
class SomeClass{
	private SomeDependency someDependency;
	
	public SomeClass(SomeDependency someDependency) {
		super();
		this.someDependency = someDependency;
		System.out.println("All Dependencies are ready");
	}
	
	@PostConstruct
	public void initilize() {
		someDependency.getReady();
	}
	
	@PreDestroy
	public void cleanUp() {
		System.out.println("CleanUp");
	}
}

@Component
class SomeDependency{

	public void getReady() {
		System.out.println("Some Logic using some dependency.");
		
	}
	
}


@Configuration
@ComponentScan
public class PrePostAnnotationsContextLauncherApplication {
	
	public static void main(String[] args) {
		try (var ctx = 
				new AnnotationConfigApplicationContext
					(PrePostAnnotationsContextLauncherApplication.class)) {
			Arrays.stream(ctx.getBeanDefinitionNames())
					.forEach(System.out::println);
		}

	}
}
