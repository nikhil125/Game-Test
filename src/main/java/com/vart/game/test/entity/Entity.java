package com.vart.game.test.entity;

import com.vart.game.test.Screen;
import com.vart.game.test.level.Level;

import java.util.Random;

public abstract class Entity {
	protected int x, y;
	private boolean removed = false;
	private Level level;
	private final Random random = new Random();

	public void update() {

	}

	public void render(Screen screen) {

	}

	public void remove() {
		// remove from level
		removed = true;
	}

	public boolean isRemoved() {
		return removed;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
}
