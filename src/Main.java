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
		width = (int) screen.getWidth() - 100; //subtracted 100 so that the window fits with os toolbars, etc
		height = (int) screen.getHeight() - 100;
		
		System.out.println("Screen Width: " + (int) screen.getWidth());
		System.out.println("Screen Height: " + (int) screen.getHeight());
		System.out.println("Game Width: " + width);
		System.out.println("Game Height: " + height);
		
		Assets.loadWorld(System.getProperty("user.dir") + "/bin/resources/world.map");
		System.out.println("First Byte: " + Assets.worldData[0]);
		
		//Game game = new Game("Pathfinder", width, height);
		//game.isRunning = true;
		//game.run();
	}

}
