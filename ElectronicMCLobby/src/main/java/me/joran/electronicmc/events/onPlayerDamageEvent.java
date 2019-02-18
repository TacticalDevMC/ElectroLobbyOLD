package me.joran.electronicmc.events;

import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

public class onPlayerDamageEvent implements Listener {

    @EventHandler
    public void onDameg(EntityDamageEvent event)  {
        Entity entity = event.getEntity();

        if (entity.getType() == EntityType.CREEPER || entity.getType() == EntityType.ZOMBIE || entity.getType() == EntityType.SPIDER || entity.getType() == EntityType.SKELETON || entity.getType() == EntityType.PLAYER) {
            event.setCancelled(true);
        }
    }

}
