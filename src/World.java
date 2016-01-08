import java.awt.Graphics;
import java.awt.Rectangle;

public class World
{
	private int tiles[][];
	private Rectangle tileRect[][];
	public static int width, height, xSpawn, ySpawn;
	
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
		tileRect = new Rectangle[width][height];
		for(int y = 0; y < height; y++)
		{
			for(int x = 0; x < width; x++)
			{
				if(Assets.getWorldData().length > (x + y * width))
				{
					tiles[x][y] = Assets.getWorldData()[(x + y * width)];
					tileRect[x][y] = getTile(x, y).getBounds(x, y);
				}
				else
				{
					tiles[x][y] = 0;
					tileRect[x][y] = getTile(x, y).getBounds(x, y);
				}
			}
		}
	}
	
	public Tile getTile(int x, int y)
	{
		if (x < 0 || y < 0 || x >= width || y >= height) {
			return Tile.dirt;
		}
		Tile t = Tile.tiles[tiles[x][y]];
		if (t == null) {
			return Tile.dirt;
		}
		return t;
	}
	
	public Rectangle getBounds(int x, int y)
	{
		return tileRect[x][y];
		//return new Rectangle(x, y, 32, 32);
	}
	
	public void update()
	{
		
	}
	
	public void render(Graphics g)
	{
		for (int y = 0; y < height; y++)
		{
			for (int x = 0; x < width; x++)
			{
				if (x > (Camera.xOffset - 32) / 32 && y > (Camera.yOffset - 32) / 32 && x < (Camera.xOffset + Game.width) / 32 && y < (Camera.yOffset + Game.height) / 32) {
					getTile(x, y).render(g, (x * Tile.width) - (int) Camera.xOffset, (y * Tile.height) - (int) Camera.yOffset);
				}
			}
		}
	}
	
	
	
}
