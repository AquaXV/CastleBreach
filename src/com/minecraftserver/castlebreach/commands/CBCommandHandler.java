package com.minecraftserver.castlebreach.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.minecraftserver.castlebreach.CastleBreach;

public class CBCommandHandler {

    private CommandSender getSender(CommandSender cmdsender) {
        CommandSender sender;
        if (!cmdsender.equals(Bukkit.getConsoleSender())) {
            sender = (Player) cmdsender;
        } else {
            sender = cmdsender;
        }
        return sender;
    }

    public void executeCommand(CommandSender cmdsender, Command cmd, String label, String[] args,
            CastleBreach cb) {

        CommandSender sender;
        sender = getSender(cmdsender);

        if (args.length < 1) {
            CBHelpcmd.run(sender);
        } else if (args[0].equalsIgnoreCase("help")) {
            CBHelpcmd.run(sender);
        } else if (args[0].equalsIgnoreCase("version")) {
            CBVersioncmd.run(sender, cb);
        } else if (args[0].equalsIgnoreCase("region")) {
            CBRegioncmd.run(sender, args, cb);
        } else if (args[0].equalsIgnoreCase("lookup")) {
            CBLookupcmd.run(sender, args, cb);
        }
    }

}
