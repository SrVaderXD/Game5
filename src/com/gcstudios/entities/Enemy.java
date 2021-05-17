package com.gcstudios.entities;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Enemy extends Entity {

	public boolean right = true, left = false;

	public int vida = 3;

	public Enemy(double x, double y, int width, int height, double speed, BufferedImage sprite) {
		super(x, y, width, height, speed, sprite);
	}

	public void tick() {
		x+=speed;
	}

	public void render(Graphics g) {
		super.render(g);
	}

}
