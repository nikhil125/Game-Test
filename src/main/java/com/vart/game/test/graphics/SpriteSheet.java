package com.vart.game.test.graphics;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class SpriteSheet {
	private final String path;
	private final int SIZE;
	private final int[] pixels;
	public static SpriteSheet TILES = new SpriteSheet("/textures/grass-tex.png", 257);
	public static SpriteSheet PLAYER_TILES = new SpriteSheet("/textures/grid-8x8-skl.png", 864);

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
}