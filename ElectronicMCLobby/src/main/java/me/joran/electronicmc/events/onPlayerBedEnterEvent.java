package me.joran.electronicmc.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerBedEnterEvent;

public class onPlayerBedEnterEvent implements Listener {

    @EventHandler
    public void PlayerBadEnter(PlayerBedEnterEvent event) {
        event.setCancelled(true);
    }
}
