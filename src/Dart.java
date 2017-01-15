import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Dart extends GameObject
{
	
	public static int DartVelX, DartVelY;
	
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
		
		if(x < 0 || x > 1280 || y < 0 || y > 960)
		{
			handler.removeObject(this);
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
		g.setColor(Color.GRAY);
		g.fillRect(x, y, 15, 15);
	}
	public Rectangle getBounds() 
	{
		return new Rectangle(x, y, 15, 15);
	}

}
