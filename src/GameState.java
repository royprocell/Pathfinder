import java.awt.Graphics;

public class GameState extends State
{
	protected static World world;
	public static EntityPlayer player;
	
	public GameState()
	{
		world = new World();
		player = new EntityPlayer(World.xSpawn * 32, World.ySpawn * 32, 64, 64);
	}
	
	public void update()
	{
		world.update();
		player.update();
	}

	public void render(Graphics g)
	{
		world.render(g);
		player.render(g);
	}

}
