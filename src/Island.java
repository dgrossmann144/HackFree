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
		g.fillRect(384, 256, 512, 384);
		for(int i = 0; i < 16; i++)
			for(int j = 0; j < 12; j++)
			{
				if(j==0)
				{
					g.drawImage(islandGrassDown, 384 + (i*32), 256, null);
				}
				else if(i == 0)
				{
					g.drawImage(islandGrassRight, 384, 256 + (j*32), null);
				}
				else if(i == 15)
				{
					g.drawImage(islandGrassLeft, 864, 256 + (32 * j), null);
				}
				else if (j == 11)
				{
					g.drawImage(islandGrassUp, 384+(i*32), 608, null);
				}
				else 
					g.drawImage(islandGrass, 384+(32 * i), 256+(32*j), null);
			}
		g.drawImage(islandCorner1, 384, 256, null);
		g.drawImage(islandCorner2, 864, 256, null);
		g.drawImage(islandCorner3, 864, 608, null);
		g.drawImage(islandCorner4, 384, 608, null);
		
	}
	public Rectangle getBounds()
	{
		return new Rectangle(384, 256, 512, 384);
	}

}
