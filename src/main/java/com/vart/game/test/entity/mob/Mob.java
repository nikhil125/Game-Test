package com.vart.game.test.entity.mob;

import com.vart.game.test.entity.Entity;
import com.vart.game.test.graphics.Sprite;

public abstract class Mob extends Entity {
	protected Sprite sprite;
	protected int direction = 0;
	protected boolean moving = false;

	public void move(int xa, int ya) {
		if (xa > 0) direction = 1;
		if (xa < 0) direction = 3;
		if (ya > 0) direction = 2;
		if (xa < 0) direction = 0;
		if (!collision()) {
			x += xa;
			y += ya;
		}
	}

	public void update() {

	}

	public void render() {

	}

	private boolean collision() {
		return false;
	}
}
