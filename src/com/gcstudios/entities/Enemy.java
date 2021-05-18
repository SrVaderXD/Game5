package com.gcstudios.entities;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.gcstudios.main.Game;
import com.gcstudios.world.AStar;
import com.gcstudios.world.Vector2i;
import com.gcstudios.world.World;

public class Enemy extends Entity {

	public boolean right = true, left = false;

	public int life = 3;

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
	}

	public void render(Graphics g) {
		super.render(g);
	}

}
