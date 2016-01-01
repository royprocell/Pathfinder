import java.awt.Graphics;
import java.awt.Rectangle;


public class World
{
	private int tiles[][];
	private int width, height, xSpawn, ySpawn;
	
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
				tiles[x][y] = Assets.getWorldData()[(x + y * width)];
			}
		}
	}
	
	public Tile getTile(int x, int y)
	{
		return null;
	}
	
	public Rectangle getBounds(int x, int y)
	{
		return new Rectangle(x, y, 32, 32);
	}
	
	public void update()
	{
		
	}
	
	public void render(Graphics g)
	{
		
	}
	
}
