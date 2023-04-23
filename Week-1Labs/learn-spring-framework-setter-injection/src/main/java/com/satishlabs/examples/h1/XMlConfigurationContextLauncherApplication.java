package com.satishlabs.examples.h1;

import java.util.Arrays;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.satishlabs.game.GameRunner;



public class XMlConfigurationContextLauncherApplication {
	
	public static void main(String[] args) {
		try (var ctx = 
				new ClassPathXmlApplicationContext("contextConfiguration.xml")){
			Arrays.stream(ctx.getBeanDefinitionNames())
					.forEach(System.out::println);
			
			System.out.println(ctx.getBean("name"));
			System.out.println(ctx.getBean("age"));
			//System.out.println(ctx.getBean("game"));
			ctx.getBean(GameRunner.class).run();
		}

	}
}
