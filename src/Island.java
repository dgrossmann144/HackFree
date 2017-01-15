import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class Island extends GameObject
{
	Handler handler;
	BufferedImage islandCorner1, islandCorner2, islandCorner3, islandCorner4, islandGrassUp,
					islandGrassDown, islandGrassRight, islandGrassLeft, islandGrass;
	
	public Island(int x, int y, ID id, Handler handler) 
	{
		super(x, y, id);
		this.handler = handler;
		
		SpriteSheet ss = new SpriteSheet(Game.sprite_sheet);
		
		islandCorner1 = ss.grabImage(3, 7, 32, 32);
		islandCorner2 = ss.grabImage(3, 6, 32, 32);
		islandCorner3 = ss.grabImage(4, 1, 32, 32);
		islandCorner4 = ss.grabImage(3, 8, 32, 32);
		islandGrassUp = ss.grabImage(3, 4, 32, 32);
		islandGrassDown = ss.grabImage(3, 3, 32, 32);
		islandGrassRight = ss.grabImage(3, 2, 32, 32);
		islandGrassLeft = ss.grabImage(3, 5, 32, 32);
		islandGrass = ss.grabImage(4, 2, 32, 32);
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
		g.drawImage(islandCorner1, 400, 200, null);
		g.drawImage(islandCorner2, 900 - 32, 200, null);
		g.drawImage(islandCorner3, 900 - 32, 700 - 32, null);
		g.drawImage(islandCorner4, 400, 700 - 32, null);
		
		for (int x = 400 + 32; x < 900 - 32; x += 32)
			for (int y = 200 + 32; y < 700 - 32; y += 32)
				g.drawImage(islandGrassUp, 32, 32, null);
	}
	public Rectangle getBounds()
	{
		return new Rectangle(400, 200, 500, 500);

	}

}
