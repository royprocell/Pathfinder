package com.pathfinder;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

public class Game
{
	private Display display;
	public static Camera camera;
	private Graphics g;
	private BufferStrategy bs;
	public static int width;
	public static int height;
	public boolean isRunning = false;
	public static State gameState, menuState, bankState;
	
	public Game(String title, int width, int height)
	{
		Game.width = width;
		Game.height= height;
		
		display = new Display(title, width, height);
	}
	
	private void init()
	{
		Assets.init();
		gameState = new GameState();
		menuState = new MenuState();
		bankState = new BankState();
		State.setState(gameState);
		camera = new Camera(0, 0);
	}
	
	private void update()
	{
		if (State.getState() != null)
		{
			State.getState().update();
		}
		Display.updateKeys();
	}
	
	private void render()
	{
		bs = display.getCanvas().getBufferStrategy();
		if(bs == null)
		{
			display.getCanvas().createBufferStrategy(3);
			return;
		}
		g = bs.getDrawGraphics();
		g.clearRect(0, 0, width, height);
		
		//this is where we actually render
		if(State.getState() != null)
		{
			State.getState().render(g);
		}
		//end where render code is
		
		bs.show();
		g.dispose();
	}
	
	public void run()
	{
		init();
		while(isRunning)
		{
			update();
			render();
			try {
				Thread.sleep(33); //this will make sure that the speed that objects move in-game do not depend on cpu speed. this sets the fps at 30.
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
