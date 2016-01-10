package com.pathfinder;
import java.awt.Graphics;

public class GameState extends State
{
	protected static World world;
	public static EntityPlayer player;
	
	public GameState()
	{
		world = new World();
		player = new EntityPlayer(-3*32, -3*32, 32, 32);//World.xSpawn * 32, World.ySpawn * 32, 32, 32);
	}
	
	public void update()
	{
		world.update();
		player.update();
	}

	public void render(Graphics g)
	{
		world.render(g);
		player.render(g);
	}

}
