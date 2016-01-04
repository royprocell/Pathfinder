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
		
		System.out.println("Screen: " + (int) screen.getWidth() + "x" + (int) screen.getHeight());
		System.out.println("Game: " + width + "x" + height);
		
		Assets.loadWorld(System.getProperty("user.dir") + "/bin/resources/world.map");
		System.out.println("First Byte: " + Assets.getWorldData()[1]);
		
		Assets.loadWorldConfig(System.getProperty("user.dir") + "/src/resources/world.cfg");
		
		Game game = new Game("Pathfinder", width, height);
		game.isRunning = true;
		game.run();
	}

}
