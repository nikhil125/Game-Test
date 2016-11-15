package com.vart.game.test.level;

import com.vart.game.test.Screen;
import com.vart.game.test.level.tile.Tile;

public class Level {
	protected int width, height;
	protected int[] tiles;

	public Level(int width, int height) {
		this.width = width;
		this.height = height;
		tiles = new int[width * height];
		generateLevel();
	}

	public Level(String path) {
		loadLevel(path);
	}

	private void loadLevel(String path) {

	}

	protected void generateLevel() {

	}

	public void update() {

	}

	protected void time() {

	}

	public void render(int xscroll, int yscroll, Screen screen) {
		screen.setOffset(xscroll, yscroll);
		// Corners to get tile precision
		int x0 = xscroll >> 4;// dividing by 16 to get pixel from tile size=16
		int x1 = (xscroll + screen.getWidth() +16) >> 4;// dividing by 16
		int y0 = yscroll >> 4;
		int y1 = (yscroll + screen.getHeight() +16) >> 4;
		for (int y = y0; y < y1; y++) {
			for (int x = x0; x < x1; x++) {
				Tile tile = getTile(x, y);
				tile.render(x, y, screen);
			}

		}
	}

	public Tile getTile(int x, int y) {
		if(x < 0 || y < 0 || x >=width || y >= height) return Tile.VOID_TILE;
		if (tiles[x + y * width] == 0) return Tile.GRASS_TILE;

		return Tile.VOID_TILE;
	}
}
