import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Island extends GameObject
{
	Handler handler;
	
	public Island(int x, int y, ID id, Handler handler) 
	{
		super(x, y, id);
		this.handler = handler;
	}
	public void tick()
	{

		
	}
	public void render(Graphics g) 
	{
		g.setColor(Color.orange);
		g.fillRect(400, 200, 500, 500);
	}
	public Rectangle getBounds()
	{
		return null;

	}

}
