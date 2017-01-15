import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class BasicEnemy extends GameObject // Name something else later, just testing
{
	Handler handler;
	BufferedImage image;
	
	public BasicEnemy(int x, int y, ID id, Handler handler, int initvelx ,int initvely, BufferedImage zone) 
	{
		super(x, y, id);
		this.handler = handler;
		this.image = zone;
		
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
		g.drawImage(image, x, y, null);
	}
	public Rectangle getBounds()
	{
		return new Rectangle(x, y, 32, 32);

	}

}
