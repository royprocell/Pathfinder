import java.awt.Graphics;
import java.awt.image.BufferStrategy;

public class Game
{
	private Display display;
	private Graphics g;
	private BufferStrategy bs;
	public int width;
	public int height;
	public boolean isRunning = false;
	public static State gameState, menuState, bankState;
	
	public Game(String title, int width, int height)
	{
		this.width = width;
		this.height= height;
		
		display = new Display(title, width, height);
	}
	
	private void init()
	{
		Assets.init();
		gameState = new GameState();
		menuState = new MenuState();
		bankState = new BankState();
	}
	
	private void update()
	{
		if (State.getState() != null)
		{
			State.getState().update();
		}
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