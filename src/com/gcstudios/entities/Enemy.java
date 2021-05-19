package com.gcstudios.entities;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import com.gcstudios.main.Game;
import com.gcstudios.world.AStar;
import com.gcstudios.world.Vector2i;
import com.gcstudios.world.World;

public class Enemy extends Entity {

	public double life = 30;

	public int dir = 1;

	private int animationFrames = 0, maxAnimationFrames = 30, index = 0, maxIndex = 2;

	public static boolean right = true, left = false, up = false, down = false;

	public Enemy(double x, double y, int width, int height, double speed, BufferedImage sprite) {
		super(x, y, width, height, speed, sprite);
		Vector2i start = new Vector2i(World.xINITIAL, World.yINITIAL);
		Vector2i end = new Vector2i(World.xFINAL, World.yFINAL);
		path = AStar.findPath(Game.world, start, end);
	}

	public void tick() {
		followPath(path);
		if (x >= Game.WIDTH) {
			Game.curLife--;
			Game.entities.remove(this);
		}

		if (life <= 0) {
			Game.entities.remove(this);
			Game.coins += 5;
			return;
		}

		animation();
		directionChanger();
	}

	public void render(Graphics g) {
		enemyUI(g);

		if (dir == 1) {
			g.drawImage(Entity.ENEMY1_RIGHT[index], this.getX(), this.getY(), null);
		}

		else if (dir == 2) {
			g.drawImage(Entity.ENEMY1_LEFT[index], this.getX(), this.getY(), null);
		}

		else if (dir == 3) {
			g.drawImage(Entity.ENEMY1_UP[index], this.getX(), this.getY(), null);
		}

		else if (dir == 4) {
			g.drawImage(Entity.ENEMY1_DOWN[index], this.getX(), this.getY(), null);
		}
		// super.render(g);
	}

	private void directionChanger() {
		if (right) {
			dir = 1;
		}

		if (left) {
			dir = 2;
		}

		if (up) {
			dir = 3;
		}

		if (down) {
			dir = 4;
		}
	}

	private void animation() {
		animationFrames++;
		if (animationFrames == maxAnimationFrames) {
			animationFrames = 0;
			index++;
			if (index > maxIndex)
				index = 0;
		}
	}

	private void enemyUI(Graphics g) {
		g.setColor(Color.red);
		g.fillRect((int) x, (int) (y - 5), 15, 6);

		g.setColor(Color.green);
		g.fillRect((int) x, (int) (y - 5), (int) ((life / 60) * 30), 6);
	}

}
