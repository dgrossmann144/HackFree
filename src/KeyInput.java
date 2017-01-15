import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter
{
	private Handler handler;
	private boolean[] keyDown = new boolean[4];
	
	Game game;
	
	public KeyInput(Handler handler, Game game) 
	{
		this.handler = handler;
		
		this.game = game;
		
		for (int i = 0; i <= 3; i++)
			keyDown[i] = false;
	}
	public void keyPressed(KeyEvent e) 
	{
		int key = e.getKeyCode();
		
		GameObject tempObject = null;
		for(int i = 0; i < handler.object.size(); i++) 
		{
			if(handler.object.get(i).getId() == ID.Player) 
			{
				tempObject = handler.object.get(i);
				break;
			}
		}
		
		if (key == KeyEvent.VK_W) 
		{
			tempObject.setVelY(-5);
			keyDown[0] = true;
		}
		if (key == KeyEvent.VK_S) 
		{
			tempObject.setVelY(5);
			keyDown[1] = true;
		}
		if (key == KeyEvent.VK_D) 
		{
			tempObject.setVelX(5);
			keyDown[2] = true;
		}
		if (key == KeyEvent.VK_A) 
		{
			tempObject.setVelX(-5);
			keyDown[3] = true;
		}
		if (key == KeyEvent.VK_UP && Game.canShoot) 
		{
			handler.addObject(new Dart(tempObject.getX() + 8, tempObject.getY() + 8, ID.Dart, handler, 0, -2));
			Game.canShoot = false;
		}
		if (key == KeyEvent.VK_DOWN && Game.canShoot) 
		{
			handler.addObject(new Dart(tempObject.getX() + 8, tempObject.getY(), ID.Dart, handler, 0, 2));
			Game.canShoot = false;
		}
		if (key == KeyEvent.VK_LEFT && Game.canShoot) 
		{
			handler.addObject(new Dart(tempObject.getX() + 8, tempObject.getY() + 8, ID.Dart, handler, -2, 0));
			Game.canShoot = false;
		}
		if (key == KeyEvent.VK_RIGHT && Game.canShoot) 
		{
			handler.addObject(new Dart(tempObject.getX(), tempObject.getY() + 8, ID.Dart, handler, 2, 0));
			Game.canShoot = false;
		}
		if (key == KeyEvent.VK_ESCAPE) 
		{
			System.exit(0);
		}
	}
	public void keyReleased(KeyEvent e) 
	{
		int key = e.getKeyCode();
		for (int i = 0; i < handler.object.size(); i++) 
		{
			GameObject tempObject = handler.object.get(i);
			
			if (tempObject.getId() == ID.Player) 
			{
				if (key == KeyEvent.VK_W)
				{
					keyDown[0] = false; //tempObject.setVelY(0);
				}
				if (key == KeyEvent.VK_S) 
				{
					keyDown[1] = false; //tempObject.setVelY(0);
				}
				if (key == KeyEvent.VK_D)
				{
					keyDown[2] = false; //tempObject.setVelX(0);
				}
				if (key == KeyEvent.VK_A) 
				{
					keyDown[3] = false; //tempObject.setVelX(0);
				}
				
				//vertical movement
				if(!keyDown[0] && !keyDown[1]) tempObject.setVelY(0);
				//horizontal movement
				if(!keyDown[2] && !keyDown[3]) tempObject.setVelX(0);
				
			}
		}	
	}
}
