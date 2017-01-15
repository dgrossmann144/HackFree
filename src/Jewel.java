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
		g.fillRect(645, 445, 24, 24);
	}
	public Rectangle getBounds()
	{
		return new Rectangle(720, 500, 24, 24);

	}

}
