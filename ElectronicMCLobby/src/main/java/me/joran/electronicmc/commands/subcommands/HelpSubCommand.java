package me.joran.electronicmc.commands.subcommands;

import me.joran.electronicmc.utility.ChatUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class HelpSubCommand {

    public void onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        Player player = (Player) sender;

        if (args.length == 1) {
            player.sendMessage("");
            player.sendMessage("");
            player.sendMessage(ChatUtils.format("&7---------&3&lHELP &8(1/1)&7-------------"));
            player.sendMessage(ChatUtils.format("&7Aliases: [eleclobby, electrolobby, emclobby, lobby]"));
            player.sendMessage(ChatUtils.format("&7- &c/electroniclobby help : &6&lkrijg deze lijst."));
            player.sendMessage(ChatUtils.format("&7- &c/electroniclobby setspawn : &6&lZet de spawn."));
            player.sendMessage(ChatUtils.format("&7- &c/electroniclobby setnpc <minetopia, kingdom> : &6&lSpawn een gamemode npc."));
            player.sendMessage(ChatUtils.format("&7- &c/electroniclobby spawn : &6&lGa naar de geplaatste spawn."));
//            player.sendMessage(ChatUtils.format("&7- &c/electroniclobby whitelist <add, remove, list, message, on, off, reload> <value>: &6&lVerander de whitelist."));
            player.sendMessage(ChatUtils.format("&7---------&3&lHELP&7-------------"));
        }
    }
}
