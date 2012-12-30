package com.minecraftserver.castlebreach;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;

import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class CBIOManager {

	public static <T extends Object> void save(Object obj, String path) throws Exception {
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path));
		oos.writeObject(obj);
		oos.flush();
		oos.close();
	}
	
	@SuppressWarnings("unchecked")
	public static <T extends Object> T load(String path) throws Exception {
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path));
		T result = (T) ois.readObject();
		ois.close();
		return result;
	}
	
	static String pointfile = "player_points.bin";
	static JavaPlugin jp;
	public static HashMap<String, Integer> PlayerPoints = new HashMap<String, Integer>();
	
	public static Object getPoints(Player player){
		int Points = 0;
		try {
			load("plugins" + File.separator + jp.getDataFolder() + File.separator + pointfile);
			Points = PlayerPoints.get(player.getName());
			return Points;
		} catch (Exception e){
			
		}
		return null;
	}
	
	public static Object setPoints(Player player, int Points){
		try {
			load("plugins" + File.separator + jp.getDataFolder() + File.separator + pointfile);
			PlayerPoints.put(player.getName(), Points);
			save(PlayerPoints, "plugins" + File.separator + jp.getDataFolder() + File.separator + pointfile);
		} catch (Exception e){
			
		}
		return null;
	}
	
}