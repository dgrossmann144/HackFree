
public class Enemy extends Entity
{
	public Enemy (int startx, int starty,int startHealth,int Damage,com.badlogic.gdx.math.Rectangle rectangle, int direction, float Speed)
	{
		super(startx, starty,startHealth,Damage,rectangle,direction, Speed);
	}
	public void move ()
	{
		//causes enemy to move to a specified point or target
		//waiting on completion of player or confirmed map size 
		/*pusudo code before completion
		 * float disx, disy
		 * disx = math.abs (super.get(x) - targetx)
		 * disy = math.abs (super.get(y) - targety)
		 * float ratio = disx/(disy + disx)
		 * super.setX = disx * ratio
		 * super.setY = disy * (1-ratio)
		 */
	}
	
}
