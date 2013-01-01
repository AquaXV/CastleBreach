package com.minecraftserver.castlebreach.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.minecraftserver.castlebreach.CastleBreach;
import com.minecraftserver.castlebreach.CBIOManager;

public class CBLookupcmd {

    public static boolean run(CommandSender sender, String[] args, CastleBreach cb) {
        
        Player target;
        boolean lookupself;
        
        if (args.length < 2){
            if (!sender.hasPermission("warner.user.lookup.self")){
                sender.sendMessage(ChatColor.DARK_RED + "You have insufficient permissions to do this.");
                return false;
            }
            if(sender instanceof Player){
                target = (Player) sender;
                lookupself = true;
            } else {
                return false;
            }
        } else if (args.length < 3){
            if (!sender.hasPermission("warner.user.lookup.other")) {
                sender.sendMessage(ChatColor.DARK_RED + "You have insufficient permissions to do this.");
                return false;
            } else {
                target = (Bukkit.getServer().getPlayer(args[1]));
                lookupself = false;
            }
        } else {
            sender.sendMessage(ChatColor.RED + "Incorrect usage!");
            sender.sendMessage(ChatColor.BLUE + "Available " + ChatColor.GOLD + "lookup" + ChatColor.BLUE + " commands:");
            if (sender.hasPermission("castlebreach.user.lookup")){
                sender.sendMessage(ChatColor.GOLD + "/cb lookup - See your points");
            }
            if (sender.hasPermission("castlebreach.admin.lookup")){
                sender.sendMessage(ChatColor.GOLD + "/cb lookup <user> - See the points of <user>");
            }
            return false;
        }
        
        if (target != null){
            String Points = CBIOManager.getPoints(sender, target) + "";
            String playertarget = target.getName();
            if (Points != null){
                if (lookupself){
                    sender.sendMessage(ChatColor.BLUE + "You have " + ChatColor.GOLD + Points + ChatColor.BLUE + " point(s).");
                } else if (!lookupself){
                    sender.sendMessage(ChatColor.GOLD + playertarget + ChatColor.BLUE + " has " + ChatColor.GOLD + Points + ChatColor.BLUE + " point(s).");
                }
            }
        }
        
        return true;
        
    }

}
