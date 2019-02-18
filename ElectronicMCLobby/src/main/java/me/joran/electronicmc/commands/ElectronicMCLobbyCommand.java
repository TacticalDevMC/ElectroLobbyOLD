package me.joran.electronicmc.commands;

import me.joran.electronicmc.commands.subcommands.*;
import me.joran.electronicmc.utility.ChatUtils;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.stream.Collectors;

public class ElectronicMCLobbyCommand implements CommandExecutor {

    HelpSubCommand help = new HelpSubCommand();
    SetSpawnSubCommand setspawn = new SetSpawnSubCommand();
    SpawnSubCommand spawn = new SpawnSubCommand();
    SetNpcSubCommand setnpc = new SetNpcSubCommand("setnpc");
//    WhitelistSubCommand whitelist = new WhitelistSubCommand();

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player player = (Player) sender;

            if (cmd.getName().equalsIgnoreCase("electroniclobby")) {
            if (!player.hasPermission("electronicMC.lobby")) {
                player.sendMessage(ChatUtils.format(ChatUtils.geenpermissions));
            } else if (args.length == 0) {
                player.sendMessage(ChatUtils.format(ChatUtils.prefix + "&c&lGebruik /electroniclobby help voor alle commands."));
            } else {
                switch(args[0]) {
                    case "help":
                        this.help.onCommand(sender, cmd, label, args);
                        break;
                    case "setspawn":
                        this.setspawn.onCommand(sender, cmd, label, args);
                        break;
                    case "spawn":
                        this.spawn.onCommand(sender, cmd, label, args);
                        break;
                    case "setnpc":
                        this.setnpc.onCommand(sender, cmd, label, args);
//                        player.sendMessage(ChatUtils.format(ChatUtils.prefix + "&c&lThis command is at the moment not usable."));
                        break;
                    case "online":
                        String allOnline = ChatUtils.format(Bukkit.getOnlinePlayers().stream().map(OfflinePlayer::getName).collect(Collectors.joining("&7, ")));

                        player.sendMessage(ChatUtils.format("&aAantel spelers &7" + allOnline.trim()));
                        player.sendMessage(ChatUtils.format("&6&l" + allOnline));
                        break;
                    default:
                        player.sendMessage(ChatUtils.format(ChatUtils.prefix + "&c&lGebruik /electroniclobby help voor alle commands."));
                }
            }
        }

        return false;
    }
}
