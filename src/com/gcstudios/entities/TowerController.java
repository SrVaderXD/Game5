package com.gcstudios.entities;

import java.awt.image.BufferedImage;
import com.gcstudios.main.Game;
import com.gcstudios.world.World;

public class TowerController extends Entity {

	public boolean isPressed = false;
	public int xTarget, yTarget;

	public TowerController(double x, double y, int width, int height, double speed, BufferedImage sprite) {
		super(x, y, width, height, speed, sprite);
	}

	public void tick() {
		if (isPressed) {
			isPressed = false;

			boolean free = true;

			int xx = (xTarget / 16) * 16;
			int yy = (yTarget / 16) * 16;

			Player player = new Player(xx, yy, 16, 16, 0, Game.spritesheet.getSprite(0, 112, 16, 16));

			for (int i = 0; i < Game.entities.size(); i++) {
				Entity e = Game.entities.get(i);
				if (e instanceof Player) {
					if (Entity.isColidding(e, player)) {
						free = false;
						System.out.println("You can't add a tower there is already a tower there.");
					}
				}
			}

			if (World.isFree(xx, yy)) {
				free = false;
				System.out.println("Invalid place!");
			}

			if (free) {
				if (Game.coins >= 20) {
					Game.entities.add(player);
					Game.coins -= 20;
				} else {
					System.out.println("You don't have enough coins!!");
				}
			}

		}
		
		if (Game.curLife <= 0) {
			System.exit(1);
		}

	}

}
