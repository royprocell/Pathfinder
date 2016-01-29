package com.pathfinder;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class GameObject
{
	protected BufferedImage texture;
	protected final int id;
	public static final int width = 128;
	public static final int height = 128;
	protected final Item resource;
	public static GameObject[] gameObjects = new GameObject[128];
	
	public static GameObject objTree;
	public static GameObject objTreeDead;
	public static GameObject objTreeOak;
	public static GameObject objTreeBirch;
	public static GameObject objTreeSpruce;
	public static GameObject objTreeWillow;
	public static GameObject objTreeMaple;
	public static GameObject objTreeRedwood;
	public static GameObject objTreeArcane;
	public static GameObject objOre;
	public static GameObject objOreCopper;
	public static GameObject objOreTin;
	public static GameObject objOreZinc;
	public static GameObject objOreIron;
	public static GameObject objOreCoal;
	public static GameObject objOreSilver;
	public static GameObject objOreGold;
	public static GameObject objOreTitanium;
	public static GameObject objRock = new GameObject(Assets.rock, 0, null);
	public static GameObject objLog;
	
	public GameObject(BufferedImage texture, int id, Item resource)
	{
		this.texture = texture;
		this.id = id;
		gameObjects[id] = this;
		this.resource = resource;
	}
	
	public void update()
	{
		
	}
	
	public void render(Graphics g, int x, int y)
	{
		g.drawImage(texture, x, y, width, height, null);
	}
	
	public Item resource()
	{
		return resource;
	}
	
}
