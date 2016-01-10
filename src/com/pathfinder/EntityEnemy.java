package com.pathfinder;
import java.awt.Graphics;
import java.awt.geom.Line2D;

public abstract class EntityEnemy extends EntityMob
{

	public EntityEnemy(float x, float y, int width, int height)
	{
		super(x, y, width, height);
	}
	
	public abstract void attack();
	
	public void trackPlayer()
	{
		
	}
	
	public void update()
	{
		trackPlayer();
		move();
		attack();
	}
	
	public void render(Graphics g)
	{
		
	}

}
