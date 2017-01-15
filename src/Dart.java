import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class Dart extends GameObject
{
	
	public static int DartVelX, DartVelY;
	
	public BufferedImage bulletCurrentImage;
	
	Handler handler;
	
	public Dart(int x, int y, ID id, Handler handler, int initVelx, int initVely)
	{
		super(x, y, id);
		
		this.handler = handler;
		DartVelX = initVelx;
		DartVelY = initVely;
		velX = DartVelX;
		velY = DartVelY;
		
	}
	public void tick() 
	{
		x += velX;
		y += velY;
		
		SpriteSheet ss = new SpriteSheet(Game.sprite_sheet);
		
		if(x < 0 || x > 1280 || y < 0 || y > 960)
		{
			handler.removeObject(this);
		}
		if(getVelX() == 0 && getVelY() < 0)
		{
			bulletCurrentImage = ss.grabImage(1, 5, 15, 15);
		}
		if(getVelX() == 0 && getVelY() > 0)
		{
			bulletCurrentImage = ss.grabImage(1, 8, 15, 15);
		}
		if(getVelX() > 0 && getVelY() == 0)
		{
			bulletCurrentImage = ss.grabImage(1, 6, 15, 15);
		}
		if(getVelX() < 0 && getVelY() == 0)
		{
			bulletCurrentImage = ss.grabImage(1, 7,  15, 15);
		}
		
		collision();
	}
	public void collision() 
	{
		for (int i = 0; i < handler.object.size(); i++) 
		{
			GameObject tempObject = handler.object.get(i);
			
			if (tempObject.getId() == ID.BasicEnemy) 
			{
				if (getBounds().intersects(tempObject.getBounds())) 
				{
					handler.removeObject(this);
					handler.removeObject(tempObject);
					HUD.score++;
				}
			}
		}
	}
	public void render(Graphics g) 
	{
		//g.setColor(Color.GRAY);
		//g.fillRect(x, y, 15, 15);
		g.drawImage(bulletCurrentImage, x, y, null);
	}
	public Rectangle getBounds() 
	{
		return new Rectangle(x, y, 15, 15);
	}

}
