import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;


public class Tile
{
	protected BufferedImage texture;
	protected final int id;
	public static final int width = 32;
	public static final int height = 32;
	
	public static Tile[] tiles = new Tile[256];
	public static Tile air;
	public static Tile dirt = new Tile(Assets.dirt, 0); //test id
	public static Tile grass = new Tile(Assets.grass, 97); //test id
	public static Tile stone;
	public static Tile blackDirt = new Tile(Assets.blackDirt, 102); //test id
	public static Tile sand;
	public static Tile snow;
	public static Tile rock;
	public static Tile gravel;
	public static Tile cobblestone;
	public static Tile dirtPath;
	public static Tile concrete;
	public static Tile stoneWall;
	public static Tile woodWall;

	public static Tile water;
	public static Tile deepWater;
	public static Tile stoneOre;
	public static Tile copperOre;
	public static Tile tinOre;
	public static Tile zincOre;
	public static Tile ironOre;
	public static Tile coalOre;
	public static Tile silverOre;
	public static Tile goldOre;
	public static Tile tree;
	public static Tile deadTree;
	public static Tile oakTree;
	public static Tile birchTree;
	public static Tile spruceTree;
	public static Tile willowTree;
	public static Tile mapleTree;
	public static Tile redwoodTree;
	public static Tile arcaneTree;
	
	public Tile (BufferedImage texture, int id)
	{
		this.texture = texture;
		this.id = id;
		tiles[id] = this;
	}
	
	public void update()
	{
		
	}
	
	public void render(Graphics g, int x, int y)
	{
		g.drawImage(texture, x, y, width, height, null);
	}
	
	public int getID()
	{
		return id;
	}
	
	public boolean isSolid()
	{
		return false;
	}
	
	public boolean isResource()
	{
		return false;
	}
	
	public Rectangle getBounds(int x, int y)
	{
		return new Rectangle(x, y, 32, 32);
	}
	
	public int maxResourceStackSize()
	{
		return 64;
	}
}
