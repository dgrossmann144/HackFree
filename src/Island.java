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
					HUD.HEALTH -= 75;
					handler.removeObject(tempObject);
				}
			}
		}
	}
	public void render(Graphics g) 
	{
		g.setColor(Color.orange);
		g.fillRect(400, 200, 500, 500);
	}
	public Rectangle getBounds()
	{
		return new Rectangle(400, 200, 500, 500);

	}

}
