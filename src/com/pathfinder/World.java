package com.pathfinder;
import java.awt.Graphics;
import java.awt.Rectangle;

public class World
{
	private int tiles[][];
	public static int width, height, xSpawn, ySpawn;
	
	public World()
	{
		loadWorld();
	}
	
	private void loadWorld()
	{
		Assets.loadWorldConfig(System.getProperty("user.dir") + "/bin/resources/world.cfg");
		Assets.loadWorld(System.getProperty("user.dir") + "/bin/resources/world.map");
		width = Assets.getWorldWidth();
		height = Assets.getWorldHeight();
		xSpawn = Assets.getXSpawn();
		ySpawn = Assets.getYSpawn();
		
		tiles = new int[width][height];
		for(int y = 0; y < height; y++)
		{
			for(int x = 0; x < width; x++)
			{
				if(Assets.getWorldData().length > (x + y * width))
				{
					tiles[x][y] = Assets.getWorldData()[(x + y * width)];
				}
				else
				{
					tiles[x][y] = 0;
				}
			}
		}
	}
	
	public Tile getTile(int x, int y)
	{
		if (x < 0 || y < 0 || x >= width || y >= height) {
			return Tile.dirt;
		}
		Tile t = Tile.tiles[tiles[x][y]];
		if (t == null) {
			return Tile.dirt;
		}
		return t;
	}
	
	public Rectangle getBounds(int x, int y)
	{
		return new Rectangle(x, y, 128, 128);
	}
	
	public void update()
	{
		
	}
	
	public void render(Graphics g)
	{
		for (int y = 0; y < height; y++)
		{
			for (int x = 0; x < width; x++)
			{
				if (x > (Camera.xOffset - 128) / 128 && y > (Camera.yOffset - 128) / 128 && x < (Camera.xOffset + Game.width) / 128 && y < (Camera.yOffset + Game.height) / 128) {
					getTile(x, y).render(g, (x * Tile.width) - (int) Camera.xOffset, (y * Tile.height) - (int) Camera.yOffset);
				}
			}
		}
	}
	
	
	
}
