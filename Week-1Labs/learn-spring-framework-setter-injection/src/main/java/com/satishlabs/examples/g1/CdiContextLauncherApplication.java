package com.satishlabs.examples.g1;

import java.util.Arrays;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import jakarta.inject.Inject;
import jakarta.inject.Named;

//@Component
@Named
class BusinessService{
	DataService dataService;
	
	//@Autowired
	@Inject
	public void setDataService(DataService dataService) {
		System.out.println("Setter Injection ");
		this.dataService = dataService;
	}
	
	public DataService getDataService() {
		return dataService;
	}
	
}

//@Component
@Named
class DataService{
	
}


@Configuration
@ComponentScan
public class CdiContextLauncherApplication {
	
	public static void main(String[] args) {
		try (var ctx = 
				new AnnotationConfigApplicationContext
					(CdiContextLauncherApplication.class)) {
			Arrays.stream(ctx.getBeanDefinitionNames())
					.forEach(System.out::println);
			
			System.out.println(ctx.getBean(BusinessService.class).getDataService());
		}

	}
}
