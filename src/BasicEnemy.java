import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class BasicEnemy extends GameObject // Name something else later, just testing
{
	Handler handler;
	
	public BasicEnemy(int x, int y, ID id, Handler handler, int initvelx ,int initvely) 
	{
		super(x, y, id);
		this.handler = handler;
		
		velX = initvelx;
		velY = initvely;
		
	}
	public void tick()
	{
		x += velX;
		y += velY;
		
	}
	public void render(Graphics g) 
	{
		//g.setColor(Color.red);
		//g.fillRect(x, y, 32, 32);
		g.drawImage(Spawn.shipCurrentImage, x, y, null);
	}
	public Rectangle getBounds()
	{
		return new Rectangle(x, y, 32, 32);

	}

}
