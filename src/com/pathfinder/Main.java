package com.pathfinder;
import java.awt.Dimension;
import java.awt.Toolkit;

public class Main
{
	private static Dimension screen;
	public static int width, height;

	public static void main(String[] args)
	{
		System.out.println("Game Directory: " + System.getProperty("user.dir"));
		System.out.println("User Home: " + System.getProperty("user.home"));
		
		screen = Toolkit.getDefaultToolkit().getScreenSize();
		width = (int) screen.getWidth() - 400; //subtracted 100 so that the window fits with os toolbars, etc
		height = (int) screen.getHeight() - 400;
		
		System.out.println("Screen: " + (int) screen.getWidth() + "x" + (int) screen.getHeight());
		System.out.println("Game: " + width + "x" + height);
		
		Game game = new Game("Pathfinder", width, height);
		game.isRunning = true;
		game.run();
	}

}
