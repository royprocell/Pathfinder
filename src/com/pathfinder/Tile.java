package com.pathfinder;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;


public class Tile
{
	protected BufferedImage texture;
	protected final int id;
	public static final int width = 128;
	public static final int height = 128;
	protected final boolean isSolid;
	
	public static Tile[] tiles = new Tile[256];
	
	public static Tile air = new Tile(Assets.dirt, 0, false);
	public static Tile dirt = new Tile(Assets.dirt, 1, false);
	public static Tile grass = new Tile(Assets.grass, 2, false);
	public static Tile stone = new Tile(Assets.dirt, 3, false);
	public static Tile blackDirt = new Tile(Assets.blackDirt, 4, false);
	public static Tile sand = new Tile(Assets.sand, 5, false);
	public static Tile snow = new Tile(Assets.dirt, 6, false);
	public static Tile rock = new Tile(Assets.dirt, 7, false);
	public static Tile gravel = new Tile(Assets.dirt, 8, false);
	public static Tile cobblestone = new Tile(Assets.dirt, 9, false);
	public static Tile dirtPath = new Tile(Assets.dirt, 10, false);
	public static Tile concrete = new Tile(Assets.concrete, 11, false);
	public static Tile stoneWall = new Tile(Assets.dirt, 12, true);
	public static Tile woodWall = new Tile(Assets.woodWall, 13, true);

	public static Tile water = new Tile(Assets.water, 14, true);
	public static Tile deepWater = new Tile(Assets.deepWater, 15, true);
	public static Tile stoneOre = new Tile(Assets.stoneOre, 16, true );
	public static Tile copperOre = new Tile(Assets.copperOre, 17, true);
	public static Tile tinOre = new Tile(Assets.tinOre, 18, true);
	public static Tile zincOre = new Tile(Assets.zincOre, 19, true);
	public static Tile ironOre = new Tile(Assets.dirt, 20, true);
	public static Tile coalOre = new Tile(Assets.coalOre, 21, true);
	public static Tile silverOre = new Tile(Assets.silverOre, 22, true);
	public static Tile goldOre = new Tile(Assets.goldOre, 23, true);
	public static Tile tree = new Tile(Assets.tree, 24, true);
	public static Tile deadTree = new Tile(Assets.dirt, 25, true);
	public static Tile oakTree = new Tile(Assets.dirt, 26, true);
	public static Tile birchTree = new Tile(Assets.dirt, 27, true);
	public static Tile spruceTree = new Tile(Assets.dirt, 28, true);
	public static Tile willowTree = new Tile(Assets.dirt, 29, true);
	public static Tile mapleTree = new Tile(Assets.mapleTree, 30, true);
	public static Tile redwoodTree = new Tile(Assets.redwoodTree, 31, true);
	public static Tile arcaneTree = new Tile(Assets.arcaneTree, 32, true);
	
	public Tile (BufferedImage texture, int id, boolean isSolid)
	{
		this.texture = texture;
		this.id = id;
		this.isSolid = isSolid;
		tiles[id] = this;
	}
	
	public void update()
	{
		
	}
	
	public void render(Graphics g, int x, int y)
	{
		g.drawImage(texture, x, y, width, height, null);
	}
	
	public int getID()
	{
		return id;
	}
	
	public boolean isSolid()
	{
		return isSolid;
	}
	
	public boolean isResource()
	{
		return false;
	}
	
	public Rectangle getBounds(int x, int y)
	{
		return new Rectangle(x, y, 128, 128);
	}
	
	public int maxResourceStackSize()
	{
		return 64;
	}
}
