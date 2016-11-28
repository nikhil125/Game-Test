package com.vart.game.test;

import com.vart.game.test.entity.mob.Player;
import com.vart.game.test.input.Keyboard;
import com.vart.game.test.level.Level;
import com.vart.game.test.level.RandomLevel;

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
	private static final String TITLE = "Rain";
	public volatile boolean shouldRun = false;
	private JFrame jFrame;
	private BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
	private int[] pixels = ((DataBufferInt) image.getRaster().getDataBuffer()).getData();
	private Screen screen;
	private Keyboard keyboard;
	private Level level;
//	private int x = 0, y=0;
	private Player player;

	public Game(GraphicsConfiguration config, boolean shouldRun) {

		super(config);
		this.keyboard = new Keyboard();

		Dimension dimension = new Dimension(width * scale, height * scale);
		this.shouldRun = shouldRun;
		this.screen = new Screen(width, height);
		this.jFrame = new JFrame();
		jFrame.setTitle("Rain");
//		jFrame.setResizable(false);
		jFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
//		jFrame.setUndecorated(true);
		jFrame.setVisible(true);

		setPreferredSize(dimension);
		addKeyListener(keyboard);
		this.level = new RandomLevel(64, 64);
		this.player = new Player(keyboard);
	}

	public void run() {
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jFrame.setLocationRelativeTo(null);
		jFrame.setVisible(true);
		jFrame.add(this);
		jFrame.pack();
		requestFocus();
		long lastTime = System.nanoTime();
		long timer = System.currentTimeMillis();
		double ns = 1000000000.0 / 60.0;
		double delta = 0.0;
		int frames = 0;
		int updates = 0;
		while (shouldRun) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while (delta >= 1) {
				update();
				updates++;
				delta--;
			}
			render();
			frames++;
			if (System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				jFrame.setTitle(TITLE + " | " + updates + " ups, " + frames + " fps");
				updates = 0;
				frames = 0;
			}
		}

	}

	private void render() {
		BufferStrategy bufferStrategy = getBufferStrategy();
		if (bufferStrategy == null) {
			createBufferStrategy(3);
			return;
		}
		screen.clear();
		level.render(player.getX(), player.getY(), screen);
		player.render(screen);
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
		keyboard.update();
		player.update();
	}

}
