import java.util.HashMap;
import java.util.Map;

import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;

public class AudioPlayer 
{
	public static Map<String, Sound> soundMap = new HashMap<String, Sound>();
	public static Map<String, Music> musicMap = new HashMap<String, Music>();
	
	public static void load() 
	{
		try 
		{
			//soundMap.put("gun_sound", new Sound("res/pop_gun.ogg"));
			soundMap.put("loss_sound", new Sound("res/loss_sound.ogg"));
			soundMap.put("walk_sound", new Sound("res/walk_sound.ogg"));
			soundMap.put("explosion", new Sound("res/explosion.ogg"));
			musicMap.put("game_music", new Music("res/score.ogg"));
		} 
		catch (SlickException e) 
		{
			e.printStackTrace();
		}
	}
	public static Music getMusic(String key) 
	{
		return musicMap.get(key);
	}
	public static Sound getSound(String key) 
	{
		return soundMap.get(key);
	}
	public static void endMusic(String key) 
	{
		musicMap.clear();
	}
	public static Sound endSound(String key) 
	{
		return soundMap.remove(key);
	}
}
