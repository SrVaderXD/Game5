package com.gcstudios.graphics;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import com.gcstudios.main.Game;

public class UI {

	public static BufferedImage HEART1 = Game.spritesheet.getSprite(0, 48, 16, 16);
	public static BufferedImage HEART2 = Game.spritesheet.getSprite(16, 48, 16, 16);
	public static BufferedImage COIN[] = { Game.spritesheet.getSprite(32, 48, 16, 16),
			Game.spritesheet.getSprite(48, 48, 16, 16) };

	private int animationFrames = 0, maxAnimationFrames = 14, spriteIndex = 0, maxSpriteIndex = 1;
	
	public void render(Graphics g) {

		drawHeart(g);
		drawCoin(g);
	}

	private void drawHeart(Graphics g) {
		for (int i = 0; i < Game.maxLife; i++) {
			g.drawImage(HEART2, 5 + (i * 43), 8, 48, 48, null);
		}

		for (int i = 0; i < Game.curLife; i++) {
			g.drawImage(HEART1, 5 + (i * 43), 8, 48, 48, null);
		}
	}

	private void drawCoin(Graphics g) {
		
		animationFrames++;

		if (animationFrames == maxAnimationFrames) {
			animationFrames = 0;
			spriteIndex++;

			if (spriteIndex > maxSpriteIndex) {
				spriteIndex = 0;
			}
		}
		g.setColor(Color.white);
		g.setFont(new Font("arial", Font.BOLD, 30));
		g.drawString("" + Game.coins, 600, 38);
		g.drawImage(COIN[spriteIndex], 563, 6, 38, 38, null);
	}

}
