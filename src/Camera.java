

public class Camera {
	protected static float xOffset;
	protected static float yOffset;

	public Camera(float xOffset, float yOffset) {
		this.xOffset = xOffset;
		this.yOffset = yOffset;
	}

	public void move(float xAmt, float yAmt) {
		xOffset += xAmt;
		yOffset += yAmt;
	}

	public void center(Entity e) {
		xOffset = e.x - (Game.width / 2) + (e.width/2);
		yOffset = e.y - (Game.height / 2) + (e.height/2);
	}
}
