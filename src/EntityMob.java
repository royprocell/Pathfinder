import java.awt.Graphics;

public abstract class EntityMob extends Entity
{
	public static final int defaultHealth = 10;
	public static final float defaultSpeed = 20;
	public static final int defaultWidth = 64;
	public static final int defaultHeight = 64;
	protected int health;
	protected int width, height;
	protected float speed;
	protected float xMove, yMove;
	protected Game game;
	protected GameState gameState;

	public EntityMob(float x, float y, int width, int height)
	{
		super(x, y, width, height);
		health = defaultHealth;
		speed = defaultSpeed;
		this.width = height;
		this.height = height;
	}
	
	public void move()
	{
		if(!isColliding((int) xMove, 0))
		{
			x += xMove;
		}
		
		if(!isColliding(0, (int) yMove))
		{
			y += yMove;
		}

	}
	
	private boolean isColliding(int xMove, int yMove)
	{	
		// top left
				if (GameState.world.getTile((int) ((x + xMove/* + 16 */) / 32),
						(int) ((y + yMove/* + 32 */)) / 32).isSolid()) {
					return true;
				}

				// top right
				if (GameState.world.getTile((int) (x + xMove + 32 - 1/* + 16 */) / 32,
						(int) (y + yMove/* + 32 */) / 32).isSolid()) {
					return true;
				}

				// bottom left
				//if (GameState.world.getTile((int) (x + xMove/* + 16 */) / 32,
				//		(int) (y + yMove + 32 - 1/* + 32 */) / 32).isSolid()) {
				//	return true;
				//}

				// bottom right
				//if (GameState.world.getTile((int) (x + xMove + 32 - 1/* + 16 */) / 32,
				//		(int) (y + yMove + 32 - 1/* + 32 */) / 32).isSolid()) {
				//	return true;
				//}
			
		return false;
	}
}
