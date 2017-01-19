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
			if (mouseOver(mx, my, 700, 115, 500, 100)) 
			{
				Game.gameState = Game.STATE.Game;
				handler.addObject(new Island(Game.WIDTH / 2, Game.HEIGHT / 2, ID.Island, handler));
				handler.addObject(new Player(Game.WIDTH / 2, Game.HEIGHT / 2, ID.Player, handler));
				return;
			}
			//help button
			if (mouseOver(mx, my, 400, 450, 500, 100)) 
			{
				Game.gameState = Game.STATE.Help;
			}
			//highscore button
			if (mouseOver(mx, my, 700, 515, 500, 100))
			{
				
			}
			//exit button
			if (mouseOver(mx, my, 700, 715, 500, 100)) 
			{
				System.exit(0);
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
			Font fnt = new Font("Helvetica", 1, 45);
			
			g.setFont(fnt);
			g.setColor(Color.white);
			g.drawRect(700, 715, 500, 100);
			g.drawString("Quit", 900, 783);
			
			g.setColor(Color.white);
			g.drawRect(700, 515, 500, 100);
			g.drawString("Highscores", 835, 582);
			
			g.setColor(Color.white);
			g.drawRect(700, 315, 500, 100);
			g.drawString("Help", 900, 385);
			
			g.setColor(Color.white);
			g.drawRect(700, 115, 500, 100);
			g.drawString("Play", 900, 183);
			
			g.drawImage(Game.logo, -30, 0, null);
		}
		else if (Game.gameState == Game.STATE.Lose) 
		{
			Font fnt = new Font("Comic Sans", 1, 32);
			g.setFont(fnt);
			
			g.setColor(Color.RED);
			g.drawString("You Lose!", 560, 475);
			g.drawString("Score: " + HUD.score, 570, 400);
			g.drawString("Press exit to exit the game", 445, 550);
		}
	}
}
