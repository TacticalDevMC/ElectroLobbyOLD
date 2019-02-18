package me.joran.electronicmc.commands.subcommands;

import me.joran.electronicmc.utility.ChatUtils;
import me.joran.electronicmc.utility.ConfigManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.io.IOException;

import static me.joran.electronicmc.utility.ConfigManager.spawnsFile;

public class SetSpawnSubCommand {

    public void onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player player = (Player) sender;

        ConfigManager.spawns.set("spawn.world", player.getLocation().getWorld().getName());
        ConfigManager.spawns.set("spawn.x", player.getLocation().getX());
        ConfigManager.spawns.set("spawn.y", player.getLocation().getY());
        ConfigManager.spawns.set("spawn.z", player.getLocation().getZ());
        try {
            ConfigManager.spawns.save(spawnsFile);
            player.sendMessage(ChatUtils.format(ChatUtils.prefix + "&a&lDe spawn is gezet op uw locatie!"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
