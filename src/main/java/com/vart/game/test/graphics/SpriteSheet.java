package com.vart.game.test.graphics;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class SpriteSheet {
	private final String path;
	private final int SIZE;
	private final int[] pixels;
	public static SpriteSheet TILES = new SpriteSheet("/textures/grid-256.png", 256);
	public static SpriteSheet PLAYER_TILES = new SpriteSheet("/textures/grid-256.png", 256);

	public SpriteSheet(String path, int size) {
		this.path = path;
		this.SIZE = size;
		this.pixels = new int[SIZE * SIZE];
		load();
	}

	public int getSIZE() {
		return SIZE;
	}

	public int[] getPixels() {
		return pixels;
	}

	private void load() {
		try {

			BufferedImage image = ImageIO.read(SpriteSheet.class.getResource(path));
			int w = image.getWidth();
			int h = image.getHeight();
			image.getRGB(0, 0, w, h, pixels, 0, w);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public int[] grab(int col, int row) throws IOException {
		BufferedImage image = ImageIO.read(SpriteSheet.class.getResource(path));

		BufferedImage subimage = image.getSubimage(col, row, 32, 32);
		int w = subimage.getWidth();
		int h = subimage.getHeight();
		return image.getRGB(0, 0, w, h, null, 0, w);
	}
}