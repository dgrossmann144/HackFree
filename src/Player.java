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
		
		System.out.println(x);
		
		x = Game.clamp(x, 0, Game.WIDTH - 37);
		y = Game.clamp(y, 0, Game.HEIGHT - 67);
				
	}
	public void render(Graphics g) 
	{
		g.setColor(Color.WHITE);
		g.fillRect(x, y, 32, 32);
	}
	public Rectangle getBounds() 
	{
		return new Rectangle(x, y, 32, 32);
	}
	
}
