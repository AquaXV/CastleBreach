package com.minecraftserver.castlebreach.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

import com.minecraftserver.castlebreach.CastleBreach;

public class CBRegioncmd {

	public static boolean run(CommandSender sender, String[] args, CastleBreach cb) {
		
		if (args.length < 2){
			if (!sender.hasPermission("castlebreach.region.help")){
				sender.sendMessage(ChatColor.DARK_RED + "You have insufficient permissions to do this.");
	            return false;
			}
			sender.sendMessage(ChatColor.RED + "Incorrect usage!");
			sender.sendMessage(ChatColor.BLUE + "Available " + ChatColor.GOLD + "region" + ChatColor.BLUE + " commands:");
			if (sender.hasPermission("castlebreach.region.define")){
				sender.sendMessage(ChatColor.GOLD + "/cb region define <regionname> - Define a region named <regionname>");
			}
			if (sender.hasPermission("castlebreach.region.delete")){
				sender.sendMessage(ChatColor.GOLD + "/cb region delete <regionname> - Delete the region <regionname>");
			}
			if (sender.hasPermission("castlebreach.region.override")){
				sender.sendMessage(ChatColor.GOLD + "/cb region override <regionname> - Make <regionname> override regions");
			}
			return false;
		}
		
		
		
		return false;
		
	}

}
