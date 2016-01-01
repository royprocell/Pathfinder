import java.awt.Graphics;


public class GameState extends State
{
	protected static World world;
	
	public GameState()
	{
		world = new World();
	}
	
	public void update()
	{
		world.update();
	}

	public void render(Graphics g)
	{
		world.render(g);
	}

}
