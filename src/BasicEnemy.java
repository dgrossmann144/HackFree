import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class BasicEnemy extends GameObject // Name something else later, just testing
{
	Handler handler;
	
	public BasicEnemy(int x, int y, ID id, Handler handler) 
	{
		super(x, y, id);
		this.handler = handler;
		
		velX = 0;
		velY = 1;
		
	}
	public void tick()
	{
		x += velX;
		y += velY;
		
	}
	public void render(Graphics g) 
	{
		g.setColor(Color.red);
		g.fillRect(x, y, 32, 32);
	}
	public Rectangle getBounds()
	{
		return new Rectangle(x, y, 32, 32);

	}

}
