package com.vart.game.test;

import com.vart.game.test.entity.mob.Player;
import com.vart.game.test.graphics.Sprite;
import com.vart.game.test.level.tile.Tile;

import java.util.Random;

public class Screen {
	private int width;
	private int height;
	private int[] pixels;
	private int[] tiles;
	private Random random;
	private final int MAP_SIZE = 64;
	private final int MAP_SIZE_MASK = MAP_SIZE - 1;
	private int xOffset, yOffset;

	public Screen(int width, int height) {
		this.width = width;
		this.height = height;
		this.pixels = new int[width * height];
		this.tiles = new int[MAP_SIZE * MAP_SIZE];
		this.random = new Random();
		for (int i = 0; i < MAP_SIZE * MAP_SIZE; i++) {
			tiles[i] = random.nextInt(0xffffff);
			tiles[0] = 0;
		}
	}

//	public void render(int xOffset, int yOffset) {
//		for (int y = 0; y < height; y++) {
//			int yy = y + yOffset;
//			if (yy >= height || yy < 0) continue;
//			for (int x = 0; x < width; x++) {
//				int xx = x + xOffset;
//				if (xx >= width || xx < 0) continue;
//				int tileIndex = ((xx >> 4) & MAP_SIZE_MASK) + ((yy >> 4) & MAP_SIZE_MASK) * MAP_SIZE; // same as x/16 + y/16*64
//				pixels[xx + yy * width] = Sprite.GRASS.getPixels()[(x & 2) + (y & 2) * Sprite.GRASS.getSIZE()]; //tiles[tileIndex];
//			}
//		}
//	}

	public void renderTile(int xOffset, int yOffset, Tile tile) {
		xOffset -= this.xOffset;
		yOffset -= this.yOffset;
		for (int y = 0; y < tile.getSprite().getSIZE(); y++) {
			int yy = y + yOffset;
			for (int x = 0; x < tile.getSprite().getSIZE(); x++) {
				int xx = x + xOffset;
				if (xx >= width || xx < -tile.getSprite().getSIZE() || yy >= height || yy < 0) break;
				if (xx < 0) xx = 0;

				pixels[xx + yy * width] = tile.getSprite().getPixels()[(x & 2) + (y & 2) * tile.getSprite().getSIZE()];
			}
		}
	}

	public void renderPlayer(int xOffset, int yOffset, Sprite sprite) {
		xOffset -= this.xOffset;
		yOffset -= this.yOffset;
		for (int y = 0; y < sprite.getSIZE(); y++) {
			int yy = y + yOffset;
			for (int x = 0; x < sprite.getSIZE(); x++) {
				int xx = x + xOffset;
				if (xx >= width || xx < -sprite.getSIZE()|| yy >= height || yy < 0) break;
				if (xx < 0) xx = 0;

				pixels[xx + yy * width] = sprite.getPixels()[(x & 2) + (y & 2) * sprite.getSIZE()];
			}
		}
	}

	public void setOffset(int xOffset, int yOffset) {
		this.xOffset = xOffset;
		this.yOffset = yOffset;
	}

	public int[] getPixels() {
		return pixels;
	}

	public void clear() {
		for (int i = 0; i < pixels.length; i++) {
			pixels[i] = 0;
		}
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public int[] getTiles() {
		return tiles;
	}
}
