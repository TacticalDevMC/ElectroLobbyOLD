package me.joran.electronicmc.events;

import me.joran.electronicmc.ElectronicMCLobby;
import me.joran.electronicmc.managers.FileManager;
import me.joran.electronicmc.utility.ConfigManager;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class playerFirstJoinEvent implements Listener {

    @EventHandler
    public void onFirstJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();


        if(!player.hasPlayedBefore()) {
            World w = Bukkit.getServer().getWorld(ConfigManager.spawns.getString("spawn.world"));
            double x = ConfigManager.spawns.getDouble("spawn.x");
            double y = ConfigManager.spawns.getDouble("spawn.y");
            double z = ConfigManager.spawns.getDouble("spawn.z");
            player.teleport(new Location(w, x, y, z));

            if (FileManager.get("data/playerData.yml").get("Spelers." + player.getUniqueId() + ".Settings." + ".ChatToggled").equals("Uit")) {
                FileManager.get("data/playerData.yml").set("Spelers." + player.getUniqueId() + ".Settings." + ".ChatToggled", "Aan");
                FileManager.save(ElectronicMCLobby.getInstance(), "data/playerData.yml");
            }
        }
    }
}
