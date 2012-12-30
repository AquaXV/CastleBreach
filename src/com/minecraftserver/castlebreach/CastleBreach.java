package com.minecraftserver.castlebreach;

import java.util.HashMap;
import java.util.List;
import java.util.logging.Logger;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

import com.minecraftserver.castlebreach.commands.CBCommandHandler;

public class CastleBreach extends JavaPlugin {
	
	Logger log = Logger.getLogger("MineCraft");
	
	public void onEnable() {
		if (!getDataFolder().exists()) getDataFolder().mkdir();
		log.info("[CastleBreach] Enabled system, version: " + getVersion() + "!");
	}
	
	public void onDisable() {
		log.info("[CastleBreach] Disabled system!");
	}
	
	public static HashMap<String, Integer> Points = new HashMap<String, Integer>();
	
	public String getVersion() {
		return this.getDescription().getVersion();
	}
	
	public String getAuthor(){
		List<String> CBAuthor = this.getDescription().getAuthors();
		String CBAuthor_String = CBAuthor.toString();
		return CBAuthor_String;
	}
	
	public boolean onCommand(CommandSender cmdsender, Command cmd, String label, String[] args) {
		if (!cmd.getName().equalsIgnoreCase("cb")) {
			return false;
		}
        CBCommandHandler cbcmd = new CBCommandHandler();
        cbcmd.executeCommand(cmdsender, cmd, label, args, this);
		return true;
	}
	
}
