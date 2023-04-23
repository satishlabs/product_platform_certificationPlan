package com.satishlabs.game;

public class GameRunner {
	private SuperContraGame marioGame;

	public GameRunner(SuperContraGame marioGame) {
		this.marioGame = marioGame;
	}

	public void run() {
		System.out.println("Running Game : " + marioGame);
		marioGame.up();
		marioGame.down();
		marioGame.left();
		marioGame.right();
	}

}
