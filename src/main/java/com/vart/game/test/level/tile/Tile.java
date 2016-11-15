package com.vart.game.test.level.tile;

import com.vart.game.test.Screen;
import com.vart.game.test.graphics.Sprite;

public abstract class Tile {
	protected int x, y;
	protected Sprite sprite;
	public static Tile GRASS_TILE = new GrassTile(0, 0, Sprite.GRASS);
	public static Tile VOID_TILE = new VoidTile(0, 0, Sprite.VOID);

	public Tile(int x, int y, Sprite sprite) {
		this.x = x;
		this.y = y;
		this.sprite = sprite;
	}

	public abstract void render(int xPos, int yPos, Screen screen);

	public boolean solid() {
		return false;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public Sprite getSprite() {
		return sprite;
	}
}
