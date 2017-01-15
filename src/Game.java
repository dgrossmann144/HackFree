import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

public class Game extends Canvas implements Runnable
{
	private static final long serialVersionUID = 1L;
	private Thread thread;
	private boolean running = false;
	
	private Handler handler;
	private HUD hud;
	private Spawn spawner;

	public static final int WIDTH = 1280, HEIGHT = WIDTH / 12 * 9; // Screen size
	
	public enum STATE 
	{
		Menu, Game;
	}
	public static STATE gameState = STATE.Game;
	
	public Game() 
	{
		handler = new Handler();
		hud = new HUD();
		spawner = new Spawn(handler, hud, this);
		
		this.addKeyListener(new KeyInput(handler, this));
		//this.addMouseListener(menu);
		
		new Window(WIDTH, HEIGHT, "HackFRee Game", this);
		
		handler.addObject(new Island(WIDTH / 2, HEIGHT / 2, ID.Island, handler));
		handler.addObject(new Player(WIDTH / 2, HEIGHT / 2, ID.Player, handler));
		handler.addObject(new BasicEnemy(680, 0, ID.BasicEnemy, handler));
		
		
	}
	public synchronized void start() 
	{
		thread = new Thread(this);
		thread.start();
		running = true;
	}
	public synchronized void stop() 
	{
		try
		{
			thread.join();
			running = false;
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	public void run() 
	{
		this.requestFocus();
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		@SuppressWarnings("unused")
		int frames = 0;
		while (running) 
		{
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while (delta >= 1) 
			{
				tick();
				delta--;
			}
			if (running)
				render();
			frames++;
			
			if(System.currentTimeMillis() - timer > 1000) 
			{
				timer += 1000;
				//System.out.println("FPS: " + frames);
				frames = 0;
			}
		}
		stop();
	}
	private void tick() 
	{
		if (gameState == STATE.Game) 
		{
			hud.tick();
			spawner.tick();
			handler.tick();
		}
		
	}
	private void render()
	{
		BufferStrategy bs = this.getBufferStrategy();
		if (bs == null) 
		{
			this.createBufferStrategy(3);
			return;
		}
		Graphics g = bs.getDrawGraphics();
		
		g.setColor(Color.cyan);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		
		handler.render(g);
		
		if(gameState == STATE.Game) 
		{
			hud.render(g);
		}
		
		g.dispose();
		bs.show();
	}
	public static int clamp(int var, int min, int max) 
	{
		if (var >= max)
			return var = max;
		else if (var <= min)
			return var = min;
		else
			return var;
	}
	public static void main(String[] args)
	{
		new Game();
	}
}
