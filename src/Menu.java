import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Menu extends MouseAdapter
{
	private Game game;
	private Handler handler;
	private HUD hud;
	
	public Menu(Game game, Handler handler, HUD hud) 
	{
		this.game = game;
		this.hud = hud;
		this.handler = handler;
	}
	public void mousePressed(MouseEvent e) 
	{
		int mx = e.getX();
		int my = e.getY();
		
		if (Game.gameState == Game.STATE.Menu) 
		{
			//play button
			if (mouseOver(mx, my, 400, 300, 500, 100)) 
			{
				Game.gameState = Game.STATE.Game;
				return;
			}
			if (mouseOver(mx, my, 400, 450, 500, 100)) 
			{
				Game.gameState = Game.STATE.Help;
			}
		}
	}
	public void mouseReleased(MouseEvent e) 
	{
		
	}
	private boolean mouseOver(int mx, int my, int x, int y, int width, int height) 
	{
		if (mx > x && mx < x + width)
			if (my > y && my < y + height)
				return true;
			else return false;
		else return false;
	}
	public void tick() 
	{
		
	}
	public void render(Graphics g) 
	{
		if (Game.gameState == Game.STATE.Menu) 
		{
			g.setColor(Color.white);
			g.drawRect(400, 750, 500, 100);
			g.drawString("Quit", 600, 818);
			
			g.setColor(Color.white);
			g.drawRect(400, 600, 500, 100);
			g.drawString("Highscores", 535, 667);
			
			g.setColor(Color.white);
			g.drawRect(400, 450, 500, 100);
			g.drawString("Help", 600, 517);
			
			g.setColor(Color.white);
			g.drawRect(400, 300, 500, 100);
			g.drawString("Play", 600, 367);
		}
		else if (Game.gameState == Game.STATE.Lose) 
		{
			Font fnt = new Font("Comic Sans", 1, 32);
			g.setFont(fnt);
			
			g.setColor(Color.RED);
			g.drawString("You Lose!", Game.WIDTH / 2, Game.HEIGHT / 2);
			g.drawString("Score: " + HUD.score, 500, 500);
			g.drawString("Press enter to play again", 500, 600);
		}
	}
}
