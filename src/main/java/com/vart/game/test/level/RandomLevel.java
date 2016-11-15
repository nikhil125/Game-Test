package com.vart.game.test.level;

import java.util.Random;

/**
 * Created by Nikhil on 11/5/2016.
 */
public class RandomLevel extends Level {
	private static Random random = new Random();

	public RandomLevel(int width, int height) {
		super(width, height);
	}

	public RandomLevel(String path) {
		super(path);
	}

	@Override
	protected void generateLevel() {
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				tiles[x + y * width] = random.nextInt(4);
			}
		}
	}
}
