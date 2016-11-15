package com.vart.game.test.level.tile;

import com.vart.game.test.Screen;
import com.vart.game.test.graphics.Sprite;

public class VoidTile extends Tile {
	public VoidTile(int x, int y, Sprite aVoid) {
		super(x, y, aVoid);
	}

	public void render(int xPos, int yPos, Screen screen) {
		screen.renderTile(xPos << 4, yPos << 4, this);
	}
}