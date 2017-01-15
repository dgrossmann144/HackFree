import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Player extends GameObject
{
	Handler handler;
	
	public Player(int x, int y, ID id, Handler handler) 
	{
		super(x, y, id);
		this.handler = handler;
	}
	public void tick() 
	{
		x += velX;
		y += velY;
		
		x = Game.clamp(x, 384, 864);
		y = Game.clamp(y, 224, 704);

				
	}
	public void render(Graphics g) 
	{
		g.setColor(Color.black);
		g.fillRect(x, y, 32, 32);
	}
	public Rectangle getBounds() 
	{
		return new Rectangle(x, y, 32, 32);
	}
	
}
