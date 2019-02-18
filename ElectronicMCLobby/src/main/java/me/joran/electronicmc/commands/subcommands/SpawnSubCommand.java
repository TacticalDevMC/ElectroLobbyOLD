package me.joran.electronicmc.commands.subcommands;

import me.joran.electronicmc.utility.ChatUtils;
import me.joran.electronicmc.utility.ConfigManager;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SpawnSubCommand {

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player p = (Player) sender;

        if (ConfigManager.spawns.getConfigurationSection("spawn") == null) {
            p.sendMessage(ChatUtils.format(ChatUtils.prefix + "&c&lEr is geen spawn gezet!"));
            return true;
        }

        World w = Bukkit.getServer().getWorld(ConfigManager.spawns.getString("spawn.world"));
        double x = ConfigManager.spawns.getDouble("spawn.x");
        double y = ConfigManager.spawns.getDouble("spawn.y");
        double z = ConfigManager.spawns.getDouble("spawn.z");
        p.teleport(new Location(w, x, y, z));
        p.sendMessage(ChatUtils.format(ChatUtils.prefix + "&a&lU bent geteleporteerd naar de spawn!"));

        return false;
    }
}
