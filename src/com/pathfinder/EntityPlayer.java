package com.pathfinder;
import java.awt.Graphics;

public class EntityPlayer extends EntityMob
{

	public EntityPlayer(float x, float y, int width, int height)
	{
		super(x, y, 64, 64);//EntityMob.defaultWidth, EntityMob.defaultHeight);
		speed = 16;
	}

	public void update()
	{
		getInput();
		move();
		Game.camera.center(this);
		System.out.println("Location: " + (double) x/128 + "," + (double) y/128);
		System.out.println("Movement Booleans: " + Display.up + "," + Display.down + "," + Display.right + "," + Display.left);
	}

	public void render(Graphics g)
	{
		g.drawImage(Assets.playerStill, (int) (x - Camera.xOffset), (int) (y - Camera.yOffset), width, height, null);
	}
	
	public void getInput()
	{
		xMove = 0;
		yMove = 0;
		if (Display.up == true) {
			yMove -= speed;
		}

		if (Display.down == true) {
			yMove += speed;
		}

		if (Display.left == true) {
			xMove -= speed;
		}

		if (Display.right == true) {
			xMove += speed;
		}
	}

}
