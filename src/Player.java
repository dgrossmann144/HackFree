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
<<<<<<< HEAD
		
		System.out.println(x);
		
		x = Game.clamp(x, 400, 900 - 32);
		y = Game.clamp(y, 200, 700 - 32);
=======
		x = Game.clamp(x, 0, Game.WIDTH - 37);
		y = Game.clamp(y, 0, Game.HEIGHT - 67);
>>>>>>> 9733493d8eb08babbc98562c1528f69acb2b37cb
				
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
