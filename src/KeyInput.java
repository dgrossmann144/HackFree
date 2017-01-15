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
		for(int x = 0; x < handler.object.size(); x++)
		{
			if(handler.object.get(x).getId() == ID.Player)
			{
				if (key == KeyEvent.VK_W) 
				{
					tempObject.setVelY(-5);
					keyDown[0] = true;
				}
				else if (key == KeyEvent.VK_S) 
				{
					tempObject.setVelY(5);
					keyDown[1] = true;
				}
				else if (key == KeyEvent.VK_D) 
				{
					tempObject.setVelX(5);
					keyDown[2] = true;
				}
				else if (key == KeyEvent.VK_A) 
				{
					tempObject.setVelX(-5);
					keyDown[3] = true;
				}
				else if (key == KeyEvent.VK_UP) 
				{
					if(Game.canShoot)
					{
						handler.addObject(new Dart(tempObject.getX() + 16, tempObject.getY(), ID.Dart, handler,0,-2));
						Dart.DartVelY = -2;
						Dart.DartVelX = 0;
						Game.canShoot = false;
					}
				}
				else if (key == KeyEvent.VK_DOWN) 
				{
					if(Game.canShoot)
					{	
						handler.addObject(new Dart(tempObject.getX() + 16, tempObject.getY() + 32, ID.Dart, handler,0,2));
						Dart.DartVelY = 2;
						Dart.DartVelX = 0;
						Game.canShoot = false;
					}
				}
				else if (key == KeyEvent.VK_LEFT) 
				{
					if(Game.canShoot)
					{
						handler.addObject(new Dart(tempObject.getX(), tempObject.getY() + 16, ID.Dart, handler,-2,0));
						Dart.DartVelX = -2;
						Dart.DartVelY = 0;
						Game.canShoot = false;
					}
				}
					
				else if (key == KeyEvent.VK_RIGHT) 
				{
					if(Game.canShoot)
					{
						handler.addObject(new Dart(tempObject.getX() + 32, tempObject.getY() + 16, ID.Dart, handler,2,0));
						Dart.DartVelX = 2;
						Dart.DartVelY = 0;
						Game.canShoot = false;
					}
				}
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
		if (key == KeyEvent.VK_UP) 
		{
			handler.addObject(new Dart(tempObject.getX() + 16, tempObject.getY(), ID.Dart, handler, 0, -2));
		}
		if (key == KeyEvent.VK_DOWN) 
		{
			handler.addObject(new Dart(tempObject.getX() + 16, tempObject.getY() + 32, ID.Dart, handler, 0, 2));
		}
		if (key == KeyEvent.VK_LEFT) 
		{
			handler.addObject(new Dart(tempObject.getX(), tempObject.getY() + 16, ID.Dart, handler, -2, 0));
		}
		if (key == KeyEvent.VK_RIGHT) 
		{
			handler.addObject(new Dart(tempObject.getX() + 32, tempObject.getY() + 16, ID.Dart, handler, 2, 0));
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
