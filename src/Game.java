import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

public class Game extends Canvas implements Runnable
{
	private static final long serialVersionUID = 1L;
	private Thread thread;
	private boolean running = false;

	public static final int WIDTH = 1280, HEIGHT = WIDTH / 12 * 9; // Screen size
	
	public Game() 
	{
		new Window(WIDTH, HEIGHT, "HackFRee Game", this);
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