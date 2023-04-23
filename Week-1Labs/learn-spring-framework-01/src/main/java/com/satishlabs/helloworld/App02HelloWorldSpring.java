package com.satishlabs.helloworld;

import java.util.Arrays;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App02HelloWorldSpring {
	public static void main(String[] args) {
		// 1. Launch a spring Context
		try (var ctx = new AnnotationConfigApplicationContext(HelloWorldConfiguration.class)) {
			// 2. Configure the things that we want Spring to manage - @Configuration
			// HelloWorldConfiguration - @Configuration
			// name - @Bean

			// 3. Retrieving Beans managed by Spring
			System.out.println(ctx.getBean("name"));
			System.out.println(ctx.getBean("age"));
			System.out.println(ctx.getBean("person"));
			System.out.println(ctx.getBean("person1"));
			// System.out.println(ctx.getBean("person2MethodCall"));
			System.out.println(ctx.getBean("person2MethodCall1"));
			// System.out.println(ctx.getBean("person2Parameters"));
			System.out.println(ctx.getBean("address2"));
			System.out.println(ctx.getBean("address3"));

			System.out.println(ctx.getBean(Person.class));
			System.out.println(ctx.getBean(Address.class));
			// How can I list all beans managed by Spring Framework
			Arrays.stream(ctx.getBeanDefinitionNames()).forEach(System.out::println);

			System.out.println(ctx.getBean("person4Qualifier"));
		}

	}
}
