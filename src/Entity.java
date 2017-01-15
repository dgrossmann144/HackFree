

import java.awt.Rectangle;

public class Entity extends GameObject
{

	protected int health;//current health of creature
	protected int damage;//Damage done by creature
	protected float speed;
	protected Rectangle hitBox;
	/**
	 * Direction is the direction of the entity<br>
	 * 0 = up<br>
	 * 1 = down<br>
	 * 2 = left<br>
	 * 3 = right<br>
	 * 4 = up left<br>
	 * 5 = up right<br>
	 * 6 = down left<br>
	 * 7 = down right<br>
	 * 8 = stationary<br>*/
	private int direction;
	public Entity (int startx, int starty,int startHealth,int Damage,Rectangle rectangle, int direction, float Speed)
	{
		super(startx,starty);
		pos.x = startx; 
		pos.y = starty;
		this.health = startHealth;
		this.damage = Damage;
		this.hitBox = rectangle;
		this.direction = direction;
	}
	/**
	 * @param damage done by other entity
	 * @return health after taking damage
	 */
	public void takeDamage (int damage)
	{
		health = health - damage;
	}
	/**
	 * @return if health is less than 0 return 0 else return 1
	 */
	public boolean isDead ()
	{
		return (health > 0);
	}
	/**
	 * @return entity's damage stat
	 */ 
	public int returnDamage ()
	{
		return damage;
	}
	public int returnHealth ()
	{
		return health;                                                                                                     
	}
	public float getSpeed ()
	{
		return speed;
	}
}
