package com.vart.game.test;

/**
 * Created by Nikhil on 10/22/2016.
 */
public final class TheGameStarter {
	public static void main(String[] args) throws InterruptedException {
		Game game = new Game(null, true);
		Thread thread = new Thread(game);
		thread.start();
//		thread.join();
	}
}
