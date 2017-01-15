import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter
{
	private Handler handler;
	
	Game game;
	
	public KeyInput(Handler handler, Game game) 
	{
		this.handler = handler;
		
		this.game = game;
	}
	public void keyPressed(KeyEvent e) 
	{
		int key = e.getKeyCode();
		
		if (key == KeyEvent.VK_ESCAPE) 
		{
			System.exit(0);
		}
	}
	public void keyReleased(KeyEvent e) 
	{
		int key = e.getKeyCode();
	}
}
