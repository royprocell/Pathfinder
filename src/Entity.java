import java.awt.Rectangle;
import java.awt.Graphics;


public abstract class Entity
{
	protected float x, y;
	protected int width, height;
	
	public Entity(float x, float y, int width, int height)
	{
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	
	public Rectangle getBounds()
	{
		return new Rectangle((int) this.x, (int) this.y, this.width, this.height);
	}
	
	public abstract void update();
	
	public abstract void render(Graphics g);
	
	public float getX()
	{
		return x;
	}
	
	public float getY()
	{
		return y;
	}
}
