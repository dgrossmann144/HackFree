import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class Player extends GameObject
{
	Handler handler;
	BufferedImage currentImage;
	
	public Player(int x, int y, ID id, Handler handler) 
	{
		super(x, y, id);
		this.handler = handler;
	}
	public void tick() 
	{
		x += velX;
		y += velY;
		
		SpriteSheet ss = new SpriteSheet(Game.sprite_sheet);
		
		currentImage = ss.grabImage(1, 1, 32, 32);
		if(getVelX() == 0 && getVelY() < 0)
		{
			currentImage = ss.grabImage(1, 2, 32, 32);
		}
		if(getVelX() == 0 && getVelY() > 0)
		{
			currentImage = ss.grabImage(1, 1, 32, 32);
		}
		if(getVelX() > 0 && getVelY() == 0)
		{
			currentImage = ss.grabImage(1, 4, 32, 32);
		}
		if(getVelX() < 0 && getVelY() == 0)
		{
			currentImage = ss.grabImage(1, 3, 32, 32);
		}
		
		x = Game.clamp(x, 384, 864);
		y = Game.clamp(y, 224, 704);

				
	}
	public void render(Graphics g) 
	{
		//g.setColor(Color.black);
		//g.fillRect(x, y, 32, 32);
		g.drawImage(currentImage, x, y, null);
	}
	public Rectangle getBounds() 
	{
		return new Rectangle(x, y, 32, 32);
	}
	
}
