package com.vart.game.test.level.tile;

import com.vart.game.test.Screen;
import com.vart.game.test.graphics.Sprite;


public class GrassTile extends Tile {
	public GrassTile(int x, int y, Sprite sprite) {
		super(x, y, sprite);
	}

	@Override
	public void render(int xPos, int yPos, Screen screen) {
		screen.renderTile(xPos<<4, yPos<<4, this);
	}
}
