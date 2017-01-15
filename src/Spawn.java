import java.util.Random;

public class Spawn 
{
	private Handler handler;
	private Game game;
	private Random r = new Random();
	private HUD hud;
	private static int mobCounter;
	private static int mobDelay = 0;
	private int zone;
	
	public Spawn(Handler handler, HUD hud, Game game) 
	{
		this.handler = handler;
		this.hud = hud;
		this.game = game;
	}
	public void tick() 
	{

		if(mobDelay == 0)
		{
		if (Game.gameState == Game.STATE.Game) 
		{	
				mobDelay = 30;
//				zone = r.nextInt(10);
//				if (zone == 0) 
//				{
					handler.addObject(new BasicEnemy(r.nextInt(400) + 400, 0, ID.BasicEnemy, handler));
//				}
//				handler.addObject(new BasicEnemy(680, 0, ID.BasicEnemy, handler));
			}
		}
		else
		{
			mobDelay--;
		}
	}
	
}
