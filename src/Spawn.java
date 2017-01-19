import java.util.Random;

public class Spawn 
{
	private Handler handler;
	private Game game;
	private Random r = new Random();
	private HUD hud;
	private static int mobDelay = 0;
	private int zone;
	
	public Spawn(Handler handler, HUD hud, Game game) 
	{
		this.handler = handler;
		this.hud = hud;
		this.game = game;
		//handler.addObject(new Island(Game.WIDTH / 2, Game.HEIGHT / 2, ID.Island, handler));
		//handler.addObject(new Player(Game.WIDTH / 2, Game.HEIGHT / 2, ID.Player, handler));
	}
	public void tick() 
	{
		if(/*mobDelay == 0*/Game.gameState == Game.STATE.Game)
		{
			if (/*Game.gameState == Game.STATE.Game*/mobDelay == 0) 
			{	
				mobDelay = 55;
				zone = r.nextInt(4);
				
				
				
				SpriteSheet ss = new SpriteSheet(Game.sprite_sheet);
				
				if (zone == 0) 
				{
					handler.addObject(new BasicEnemy(r.nextInt(480) + 384, 0, ID.BasicEnemy, handler,0,1, ss.grabImage(2, 1, 32, 32)));
				}
				else if(zone == 1) 
				{
					handler.addObject(new BasicEnemy(1260, r.nextInt(352) + 250, ID.BasicEnemy, handler,-1,0, ss.grabImage(2, 4, 32, 32)));
				}	
				else if(zone == 2)
				{
					handler.addObject(new BasicEnemy(r.nextInt(480) + 384, 960, ID.BasicEnemy, handler,0,-1, ss.grabImage(2, 2, 32, 32)));
				}	
				else
				{
					handler.addObject(new BasicEnemy(0, r.nextInt(352) + 250, ID.BasicEnemy, handler,1,0, ss.grabImage(2, 3, 32, 32)));
				}
				if (HUD.HEALTH == 0) 
				{
					handler.clearObjects();
				}
			}
			else
				mobDelay--;
		}
		else if (Game.gameState == Game.STATE.Lose) 
		{
			handler.clearObjects();
		}
	}
	
}
