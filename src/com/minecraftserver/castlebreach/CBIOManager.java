package com.minecraftserver.castlebreach;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class CBIOManager {
    static CastleBreach plugin;
    static File         pointfile = new File(plugin.getDataFolder() + File.separator
                                   + "player_points.bin");
    public static HashMap<String, Integer> PlayerPoints = new HashMap<String, Integer>();

    public static void init(CastleBreach parent) {
        plugin = parent;
    }

    public static <T extends Object> void save(Object obj, String path) throws Exception {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path));
        oos.writeObject(obj);
        oos.flush();
        oos.close();
    }

    public static <T extends Object> T load(String path) throws Exception {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path));
        T result = (T) ois.readObject();
        ois.close();
        return result;
    }


    public static int getPoints(CommandSender sender, Player player) {
        int Points = 0;
        try {
            load(pointfile.toString());
            Points = PlayerPoints.get(player.getName());
            return Points;
        } catch (Exception e) {
            setPoints(sender, player, Points);
        }
        return Points;
    }

    public static Object setPoints(CommandSender sender, Player player, int Points) {
        try {
            load(pointfile.toString());
            PlayerPoints.put(player.getName(), Points);
            save(PlayerPoints, pointfile.toString());
        } catch (Exception e) {
            try {
                if (!pointfile.exists()) {
                    pointfile.mkdir();
                }
            } catch (Exception e1) {
                sender.sendMessage(ChatColor.DARK_RED + "Error saving playerfiles.");
            }
        }
        return Points;
    }

}