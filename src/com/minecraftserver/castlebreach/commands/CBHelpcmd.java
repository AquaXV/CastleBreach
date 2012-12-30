package com.minecraftserver.castlebreach.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

public class CBHelpcmd {

	public static boolean run(CommandSender sender) {
		
		if (!sender.hasPermission("castlebreach.user.help")){
			return false;
		}
		
		sender.sendMessage(ChatColor.BLUE + "Available commands (<required> [optional]):");
		
		if (sender.hasPermission("castlebreach.user.version")){
			sender.sendMessage(ChatColor.GOLD + "/cb version - See the version of the plugin");
		}
		if (sender.hasPermission("castlebreach.user.lookup")){
			sender.sendMessage(ChatColor.GOLD + "/cb lookup - See your points");
		}
		if (sender.hasPermission("castlebreach.admin.lookup")){
			sender.sendMessage(ChatColor.GOLD + "/cb lookup <name> - See the points of <name>");
		}
		if (sender.hasPermission("castlebreach.region.define")){
			sender.sendMessage(ChatColor.GOLD + "/cb region define <regionname> - Create a region named <regionname>");
		}
		if (sender.hasPermission("castlebreach.region.delete")){
			sender.sendMessage(ChatColor.GOLD + "/cb region delete <regionname> - Remove the region <regionname>");
		}
		if (sender.hasPermission("castlebreach.region.override")){
			sender.sendMessage(ChatColor.GOLD + "/cb region override <regionname> - Makes <regionname> override regions (Used for doors)");
		}
		return true;
	}

}
