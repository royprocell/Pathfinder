package com.pathfinder;
import java.awt.Graphics;

public abstract class EntityMob extends Entity
{
	public static final int defaultHealth = 10;
	public static final float defaultSpeed = 8;
	public static final int defaultWidth = 32;
	public static final int defaultHeight = 32;
	protected int health;
	protected float speed;
	protected float xMove, yMove;
	protected Game game;
	protected GameState gameState;

	public EntityMob(float x, float y, int width, int height)
	{
		super(x, y, width, height);
		health = defaultHealth;
		speed = defaultSpeed;
		width = defaultWidth;
		height = defaultHeight;
	}
	
	public void move()
	{
		/*liquid detection
		if(GameState.world.getTile((int) x / 128, (int) y / 128) == Tile.water)
		{
			if(xMove < 0)
			{
				xMove = -8;
			}
			
			if(yMove < 0)
			{
				yMove = -8;
			}
			
			if(xMove > 0)
			{
				xMove = 8;
			}
			
			if(yMove > 0)
			{
				yMove = 8;
			}
		}*/
		
		//collision detection
		if(!isColliding((int) xMove, 0))
		{
			x += xMove;
		}
		
		if(!isColliding(0, (int) yMove))
		{
			y += yMove;
		}
	}
	
	private boolean isColliding(int xMove, int yMove)
	{	
		// top left
		if (GameState.world.getTile((int) ((x + xMove) / 128), (int) ((y + yMove + (3*height/4))) / 128).isSolid())
		{
			return true;
		}

		// top right
		if (GameState.world.getTile((int) (x + xMove + width/*32*/ - 1) / 128, (int) (y + yMove + (3*height/4)) / 128).isSolid())
		{
			return true;
		}

		// bottom left
		if (GameState.world.getTile((int) (x + xMove) / 128, (int) (y + yMove + height/*32*/ - 1) / 128).isSolid())
		{
			return true;
		}

		// bottom right
		if (GameState.world.getTile((int) (x + xMove + width/*32*/ - 1) / 128, (int) (y + yMove + height/*32*/ - 1) / 128).isSolid())
		{
			return true;
		}
			
		return false;
	}
}
