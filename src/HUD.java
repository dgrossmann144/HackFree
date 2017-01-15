import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class HUD 
{
	public static int HEALTH = 450;
	public static int score = 0;
	
	public void tick() 
	{
		if (HEALTH == 0) 
		{
			AudioPlayer.endMusic("game_music");
			AudioPlayer.getSound("loss_sound").play();
		}
	}
	public void render(Graphics g) 
	{
		Font fnt = new Font("Helvetica", 1, 24);
		
		g.setFont(fnt);
		g.setColor(Color.black);
		g.drawString("Score: " + score, 25, 120);
		
		g.setColor(Color.green);
		g.fillRect(25, 25, HEALTH, 50);
		
		g.setColor(Color.BLACK);
		g.drawRect(25, 25, 450, 50);
		
	}
}
