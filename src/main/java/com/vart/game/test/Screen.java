package com.vart.game.test;

public class Screen {
	private int width;
	private int height;
	private int[] pixels;
	int xtime=60, ytime = 0;
	int counter = 0;
	public Screen(int width, int height) {
		this.width = width;
		this.height = height;
		this.pixels = new int[width * height];
	}

	public void render() {
		counter++;
		if(counter%10 ==0) {
			xtime ++;
		}
		if (counter %100 ==0) {
			ytime++;
		}
		for (int i = 0; i < height; i++) {
			if(ytime >= height)
				break;

			for (int j = 0; j < width; j++) {
				if(xtime >= width) break;
				pixels[xtime + ytime * width] = 0xff00ff;
			}
		}
	}

	public int[] getPixels() {
		return pixels;
	}

	public void clear() {
		for (int i = 0; i < pixels.length; i++) {
			pixels[i] =0 ;
		}
	}
}
