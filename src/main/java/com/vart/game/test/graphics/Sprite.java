package com.vart.game.test.graphics;

public class Sprite {
	private final int SIZE;
	private int x, y;
	private int[] pixels;
	private SpriteSheet sheet;
	public static final Sprite GRASS = new Sprite(16, 0, 0, SpriteSheet.TILES);
	public static final Sprite VOID = new Sprite(16, 0x428ff4);
	public static final Sprite PLAYER1 = new Sprite(32, 10, 15, SpriteSheet.PLAYER_TILES);
//	public static final Sprite PLAYER2 = new Sprite(32, 0, 16 , SpriteSheet.PLAYER_TILES);
//	public static final Sprite PLAYER3 = new Sprite(32, 16, 0 , SpriteSheet.PLAYER_TILES);
//	public static final Sprite PLAYER4 = new Sprite(32, 16, 16 , SpriteSheet.PLAYER_TILES);

	public Sprite(int size, int x, int y, SpriteSheet sheet) {
		this.SIZE = size;
		this.pixels = new int[SIZE * SIZE];
		this.x = x * SIZE;
		this.y = y * SIZE;
		this.sheet = sheet;
		load();
	}

	public Sprite(int size, int color) {
		SIZE = size;
		pixels = new int[SIZE * SIZE];
		setColor(color);
	}

	private void setColor(int color) {
		for (int i = 0; i < SIZE * SIZE; i++) {
			pixels[i] = color;
		}
	}

	private void load() {
		for (int y = 0; y < SIZE; y++) {
			for (int x = 0; x < SIZE; x++) {
				pixels[x + y * SIZE] = sheet.getPixels()[(x + this.x) + (y + this.y) * sheet.getSIZE()];
			}
		}
	}

	public int getSIZE() {
		return SIZE;
	}

	public int[] getPixels() {
		return pixels;
	}
}
