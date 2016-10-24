package com.vart.game.test;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

/**
 * Created by Nikhil on 10/22/2016.
 */
public class Game extends Canvas implements Runnable {
	public static final int width = 300;
	public static final int height = width / 16 * 9;
	public static final int scale = 4;
	public volatile boolean shouldRun = false;
	private JFrame jFrame;
	private BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
	private int[] pixels = ((DataBufferInt)image.getRaster().getDataBuffer()).getData();
	private Screen screen;

	public Game(GraphicsConfiguration config, boolean shouldRun) {

		super(config);
		Dimension dimension = new Dimension(width * scale, height * scale);
		this.shouldRun = shouldRun;
		setPreferredSize(dimension);
		this.screen = new Screen(width, height);
		this.jFrame = new JFrame();
		jFrame.setTitle("Rain");
		jFrame.setResizable(false);

	}

	public void run() {
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jFrame.setLocationRelativeTo(null);
		jFrame.setVisible(true);
		jFrame.add(this);
		jFrame.pack();
		while (shouldRun) {
			update();
			render();

		}

	}

	private void render() {
		BufferStrategy bufferStrategy = getBufferStrategy();
		if (bufferStrategy == null) {
			createBufferStrategy(3);
			return;
		}
		screen.clear();
		screen.render();
		Graphics graphics = bufferStrategy.getDrawGraphics();
//		graphics.setColor(Color.BLACK);
//		graphics.fillRect(0, 0, getWidth(), getHeight());
		for (int i = 0; i < pixels.length; i++) {
			pixels[i] = screen.getPixels()[i];
		}
		graphics.drawImage(image, 0, 0, getWidth(), getHeight(), null);
		graphics.dispose();
		bufferStrategy.show();
	}

	private void update() {

	}

}
