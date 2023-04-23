package com.satishlabs;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.satishlabs.game.GameConsole;
import com.satishlabs.game.GameRunner;




@Configuration
@ComponentScan("com.satishlabs.game")
public class GamingAppLauncherApplication {
	
	public static void main(String[] args) {
		try (var ctx = 
				new AnnotationConfigApplicationContext
					(GamingAppLauncherApplication.class)) {
			ctx.getBean(GameConsole.class).up();
			ctx.getBean(GameRunner.class).run();
		}

	}
}
