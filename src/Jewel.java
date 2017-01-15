import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Jewel extends GameObject
{
	Handler handler;
	
	public Jewel(int x, int y, ID id, Handler handler) 
	{
		super(x, y, id);
		this.handler = handler;
	}
	public void tick()
	{
		
	}
	
	public void render(Graphics g) 
	{
		g.setColor(Color.red);
		g.fillRect(638, 438, 24, 24);
	}
	public Rectangle getBounds()
	{
		return new Rectangle(638, 438, 24, 24);

	}

}
