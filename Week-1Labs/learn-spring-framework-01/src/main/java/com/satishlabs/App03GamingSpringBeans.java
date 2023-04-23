package com.satishlabs;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.satishlabs.game.GameConsole;
import com.satishlabs.game.GameRunner;

public class App03GamingSpringBeans {
	public static void main(String[] args) {
		try (var ctx = 
				new AnnotationConfigApplicationContext
					(GamingConfiguration.class)) {
			ctx.getBean(GameConsole.class).up();
			ctx.getBean(GameRunner.class).run();
		}

	}
}
