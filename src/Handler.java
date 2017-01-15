import java.awt.Graphics;
import java.util.LinkedList;

public class Handler 
{
	LinkedList<GameObject> object = new LinkedList<GameObject>();
	
	public void tick() 
	{
		for (int i = 0; i < object.size(); i++) 
		{
			GameObject tempObject = object.get(i);
			tempObject.tick();
		}
	}
	public void render(Graphics g) 
	{
		for (int i = 0; i < object.size(); i++) 
		{
			GameObject tempObject = object.get(i);
			tempObject.render(g);
		}
	}
	public void clearObjects() 
	{
		for (int i = 0; i < object.size(); i++) 
		{
			GameObject tempObject = object.get(i);
			
			if (tempObject.getId() == ID.Player) 
			{
				object.clear();
				if (Game.gameState != Game.STATE.Menu) 
				{
					addObject(new Player(tempObject.getX(), tempObject.getY(), ID.Player, this));
				}
			}
		}
	}
	public void addObject(GameObject object) 
	{
		this.object.add(object);
	}
	public void removeObject(GameObject object) 
	{
		this.object.remove(object);
	}
}
