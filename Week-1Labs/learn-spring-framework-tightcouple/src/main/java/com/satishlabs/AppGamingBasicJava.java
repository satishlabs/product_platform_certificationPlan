package com.satishlabs;

import com.satishlabs.game.GameRunner;
import com.satishlabs.game.MarioGame;
import com.satishlabs.game.SuperContraGame;

public class AppGamingBasicJava {
	public static void main(String[] args) {
		//var marioGame = new MarioGame();
		var superContraGame = new SuperContraGame();
		var gameRunner = new GameRunner(superContraGame);
		gameRunner.run();
	}
}
