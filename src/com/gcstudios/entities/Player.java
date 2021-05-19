package com.gcstudios.entities;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.gcstudios.main.Game;

public class Player extends Entity {

	public int xTarget, yTarget;
	public boolean isAttacking = false;

	public Player(int x, int y, int width, int height, double speed, BufferedImage sprite) {
		super(x, y, width, height, speed, sprite);
	}

	public void tick() {
		attack();
	}

	public void render(Graphics g) {
		if (isAttacking) {
			g.setColor(Color.red);
			g.drawLine((int) x+8 , (int) y+7, xTarget+8, yTarget+8);
		}
		
		super.render(g);
	}

	private void attack() {
		Enemy enemy = null;

		for (int i = 0; i < Game.entities.size(); i++) {
			Entity e = Game.entities.get(i);
			if (e instanceof Enemy) {
				int xEnemy = e.getX();
				int yEnemy = e.getY();

				if (calculateDistance(this.getX(), this.getY(), xEnemy, yEnemy) < 40) {
					enemy = (Enemy) e;
				}
			}
		}
		
		if(enemy != null) {
			isAttacking = true;
			xTarget = enemy.getX();
			yTarget = enemy.getY();
			
			if(Entity.rand.nextInt(100) < 25) {
				enemy.life -= Entity.rand.nextDouble();
			}
		}
		else
			isAttacking = false;
	}

}
