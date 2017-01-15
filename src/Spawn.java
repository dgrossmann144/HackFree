import java.util.Random;

public class Spawn 
{
	private Handler handler;
	private Game game;
	private Random r = new Random();
	private HUD hud;
	
	private int zone;
	
	public Spawn(Handler handler, HUD hud, Game game) 
	{
		this.handler = handler;
		this.hud = hud;
		this.game = game;
	}
	public void tick() 
	{
		if (Game.gameState == Game.STATE.Game) 
		{
			zone = r.nextInt(3);
			if (zone == 0) 
			{
				handler.addObject(new BasicEnemy(r.nextInt(900) + 400, r.nextInt(700) + 200, ID.BasicEnemy, handler));
			}
			handler.addObject(new BasicEnemy(680, 0, ID.BasicEnemy, handler));
		}
	}
}
