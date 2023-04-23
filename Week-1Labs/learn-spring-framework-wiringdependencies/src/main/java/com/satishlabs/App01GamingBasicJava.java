package com.satishlabs;

import com.satishlabs.game.GameRunner;
import com.satishlabs.game.MarioGame;
import com.satishlabs.game.Pacman;
import com.satishlabs.game.SuperContraGame;

public class App01GamingBasicJava {
	public static void main(String[] args) {
		//var game = new MarioGame();
		//var game = new SuperContraGame();
		var game = new Pacman(); //1. Object creation
		var gameRunner = new GameRunner(game); 
		//2. Object creation + wiring of dependencies
		//Game is Dependecny of GameRunner class
		gameRunner.run();
	}
}
