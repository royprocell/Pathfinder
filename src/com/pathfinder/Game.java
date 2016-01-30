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
				Thread.sleep(22);
				/*
				 * this will make sure that the speed that objects move in-game do not depend on cpu speed. this sets the fps at roughly 30.
				 *during testing, setting Thread.sleep(33); would result in roughly 30fps for maps smaller than 300x300, however with larger
				 *maps, such as 2048x2048, the fps was cut to about 10-15. the cause of this bug is unknown, or possibly due to having to
				 *create a larger map. this was resolved by setting Thread.sleep(22);. this brought the fps back up to 30, but increased
				 *cpu usage and memory usage. while i don't necessarily like having to use more cpu and memory resources for such a simple 
				 *game, it seems necessary at the moment for larger maps, which will definitely be required for the final map design.
				 *i will use this as a fix unless i can find a solution to larger maps creating lag with Thread.sleep(33);.
				 */
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
