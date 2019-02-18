package me.joran.electronicmc.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;

public class playerDropPickEvent implements Listener {

    @EventHandler
    public void onDrop(PlayerDropItemEvent event) {
        Player player = event.getPlayer();

        if (player.hasPermission("electroniclobby.drop")) {
            event.setCancelled(false);
        }
    }

    @EventHandler
    public void onPickUp(PlayerPickupItemEvent event) {
        Player player = event.getPlayer();

        if (player.hasPermission("electroniclobby.pickup")) {
            event.setCancelled(false);
        }
    }
}
