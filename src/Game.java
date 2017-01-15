import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.util.Random;

public class Game extends Canvas implements Runnable
{
	private static final long serialVersionUID = 1L;
	private Thread thread;
	private boolean running = false;
	public static int shotDelay = 30;
	private Handler handler;
	private HUD hud;
	private Spawn spawner;
	private Random r;
	private Menu menu;
	private BufferedImage background;
	
	public static boolean canShoot = true;
	
	public static BufferedImage sprite_sheet;

	public static final int WIDTH = 1280, HEIGHT = WIDTH / 12 * 9; // Screen size or 960
	
	public enum STATE 
	{
		Menu, Game, Help;
	}
	public static STATE gameState = STATE.Game;
	
	public Game() 
	{
		BufferedImageLoader loader = new BufferedImageLoader();
		
		sprite_sheet = loader.loadImage("/spritesheet.png");
		handler = new Handler();
		hud = new HUD();
		spawner = new Spawn(handler, hud, this);
		menu = new Menu(this, handler, hud);
		
		this.addKeyListener(new KeyInput(handler, this));
		//this.addMouseListener(menu);
		
		new Window(WIDTH, HEIGHT, "HackFRee Game", this);
		
		SpriteSheet ss = new SpriteSheet(sprite_sheet);
		
		background = ss.grabImage(3, 1, 32, 32);
		handler.addObject(new Island(WIDTH / 2, HEIGHT / 2, ID.Island, handler));
		handler.addObject(new Player(WIDTH / 2, HEIGHT / 2, ID.Player, handler));
		//handler.addObject(new BasicEnemy(680, 0, ID.BasicEnemy, handler));
		
		
		
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
		if(shotDelay == 0)
		{
			canShoot = true;
			shotDelay = 30;
		}
		else
			shotDelay--;
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
		
		
		//g.setColor(Color.cyan);
		for (int x = 0; x < WIDTH; x += 32) 
		{
			for (int y = 0; y < HEIGHT; y += 32) 
			{
				g.drawImage(background, x, y, null);
			}
		}
		
		
		
		handler.render(g);
		
		if(gameState == STATE.Game) 
		{
			hud.render(g);
		}
		else
		{
			menu.render(g);
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
