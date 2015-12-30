import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Assets
{
	public static byte worldData[];
	//natural tiles
	public static BufferedImage dirt, grass, stone, blackDirt, sand, snow, rock, gravel, water, deepWater;
	//ore tiles
	public static BufferedImage copperOre, tinOre, coalOre, goldOre, zincOre, silverOre, stoneOre, ironOre;
	//tree tiles
	public static BufferedImage tree, oakTree, birchTree, spruceTree, willowTree, mapleTree, redwoodTree, arcaneTree, deadTree;
	//manufactured tiles
	public static BufferedImage cobblestone, dirtPath, concrete, stoneWall, woodWall;
	//monster tiles
	//npc tiles
	//armor tiles
	//item tiles
	//player tiles
	//hud tiles
	
	public static void init()
	{
		dirt = ImageLoader.loadImage("/resources/dirt.png");
		grass = ImageLoader.loadImage("/resources/grass.png");
		stone = ImageLoader.loadImage("/resources/stone.png");
		blackDirt = ImageLoader.loadImage("/resources/blackDirt.png");
		sand = ImageLoader.loadImage("/resources/sand.png");
		snow = ImageLoader.loadImage("/resources/snow.png");
		rock = ImageLoader.loadImage("/resources/rock.png");
		gravel = ImageLoader.loadImage("/resources/gravel.png");
		water = ImageLoader.loadImage("/resources/water.png");
		deepWater = ImageLoader.loadImage("/resources/deepWater.png");
		
		copperOre = ImageLoader.loadImage("/resources/copperOre.png");
		tinOre = ImageLoader.loadImage("/resources/tinOre.png");
		coalOre = ImageLoader.loadImage("/resources/coalOre.png");
		goldOre = ImageLoader.loadImage("/resources/goldOre.png");
		zincOre = ImageLoader.loadImage("/resources/zincOre.png");
		silverOre = ImageLoader.loadImage("/resources/silverOre.png");
		stoneOre = ImageLoader.loadImage("/resources/stoneOre.png");
		ironOre = ImageLoader.loadImage("/resources/ironOre.png");
		
		tree = ImageLoader.loadImage("/resources/tree.png");
		oakTree = ImageLoader.loadImage("/resources/oakTree.png");
		birchTree = ImageLoader.loadImage("/resources/birchTree.png");
		spruceTree = ImageLoader.loadImage("/resources/spruceTree.png");
		willowTree = ImageLoader.loadImage("/resources/willowTree.png");
		mapleTree = ImageLoader.loadImage("/resources/mapleTree.png");
		redwoodTree = ImageLoader.loadImage("/resources/redwoodTree.png");
		arcaneTree = ImageLoader.loadImage("/resources/arcaneTree.png");
		deadTree = ImageLoader.loadImage("/resources/deadTree.png");
		
		cobblestone = ImageLoader.loadImage("/resources/cobblestone.png");
		dirtPath = ImageLoader.loadImage("/resources/dirtPath.png");
		concrete = ImageLoader.loadImage("/resources/concrete.png");
		stoneWall = ImageLoader.loadImage("/resources/stoneWall.png");
		woodWall = ImageLoader.loadImage("/resources/woodWall.png");
	}
	
	public static void loadWorld(String path)
	{
		File file = new File(path);
		FileInputStream fInput = null;
		try
		{
			fInput = new FileInputStream(file);
			//reads the bytes of the file into a byte array.
			//each byte is considered to be a tile, with the exception of the first 4 bytes, two of which are the width of the map and two of which are the height of the map.
			byte fileData[] = new byte[(int)file.length()];
			fInput.read(fileData);
			worldData = fileData;
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if(fInput != null)
				{
					fInput.close();
				}
			}
			catch(IOException e)
			{
				e.printStackTrace();
			}
		}
	}
}
