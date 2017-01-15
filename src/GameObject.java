

import com.badlogic.gdx.math.Vector2;

public abstract class GameObject 
{
	protected Vector2 pos;
	protected Vector2 vel;
	
	public GameObject(int x, int y) 
	{
		pos = new Vector2(x, y);
	}
	public void setX(int x) 
	{
		this.pos.x = x;
	}
	public void setY(int y) 
	{
		this.pos.y = y;
	}
	public float getX() 
	{
		return pos.x;
	}
	public float getY() 
	{
		return pos.y;
	}
	public void setVelX(int velX) 
	{
		this.vel.x = velX;
	}
	public void setVelY(int velY) 
	{
		this.vel.y = velY;
	}
	public float getVelX() 
	{
		return pos.x;
	}
	public float getVelY() 
	{
		return pos.y;
	}
}
