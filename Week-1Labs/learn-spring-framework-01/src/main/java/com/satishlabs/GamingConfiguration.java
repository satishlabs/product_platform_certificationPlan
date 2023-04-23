package com.satishlabs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.satishlabs.game.GameConsole;
import com.satishlabs.game.GameRunner;
import com.satishlabs.game.PacmanGame;

@Configuration
public class GamingConfiguration {
	@Bean
	public GameConsole game() {
		var game = new PacmanGame();
		return game;
	}
	
	@Bean
	public GameRunner gameRunner(GameConsole game) {
		var gameRunner = new GameRunner(game);
		return gameRunner;
	}
}
