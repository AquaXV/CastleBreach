package com.minecraftserver.castlebreach.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

import com.minecraftserver.castlebreach.CastleBreach;

public class CBVersioncmd {

	public static boolean run(CommandSender sender, CastleBreach cb){
		if (!sender.hasPermission("castlebreach.user.version")){
			sender.sendMessage(ChatColor.DARK_RED + "You have insufficient permissions to do this.");
			return false;
		}
		sender.sendMessage(ChatColor.BLUE + "CastleBreach \nVersion: " + ChatColor.GOLD + cb.getVersion() + "\n" + ChatColor.BLUE + "Author: " + ChatColor.GOLD + cb.getAuthor().replace("[", "").replace("]", ""));
		return true;

	}
	
}
