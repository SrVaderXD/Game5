package com.gcstudios.entities;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.gcstudios.main.Game;

public class Spawner extends Entity {

	private int timer = 60, curTimer = 0;

	public Spawner(double x, double y, int width, int height, double speed, BufferedImage sprite) {
		super(x, y, width, height, speed, sprite);
	}

	public void tick() {
		curTimer++;

		if (curTimer == timer) {
			curTimer = 0;
			timer = Entity.rand.nextInt(90 - 45) + 45;
			Enemy enemy = new Enemy(x, y, 16, 16, 1, Entity.ENEMY1_RIGHT);
			Game.entities.add(enemy);
		}
	}

	public void render(Graphics g) {
		// g.setColor(Color.red);
		// g.fillRect((int) x, (int) y, width, height);
	}

}
