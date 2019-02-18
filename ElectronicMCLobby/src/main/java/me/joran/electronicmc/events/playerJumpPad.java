package me.joran.electronicmc.events;

import org.bukkit.Material;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.util.Vector;

import java.util.ArrayList;

public class playerJumpPad implements Listener {

    public static ArrayList<Player> jumpers = new ArrayList<>();


    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event) {

        if (event.getTo().getBlock().getRelative(BlockFace.DOWN).getType() == Material.REDSTONE_BLOCK) {
            event.getPlayer().setVelocity(event.getPlayer().getLocation().getDirection().multiply(2));
            event.getPlayer().setVelocity(new Vector(event.getPlayer().getVelocity().getX(), 1.0D, event.getPlayer().getVelocity().getZ()));
            this.jumpers.add(event.getPlayer());
        }
    }

    @EventHandler
    public void onPlayerDamage(EntityDamageEvent e) {
        if (e.getEntity() instanceof Player) {
            Player p = (Player) e.getEntity();
            if (e.getCause() == EntityDamageEvent.DamageCause.FALL && this.jumpers.contains(p)) {
                e.setDamage(0.0);
                this.jumpers.remove(p);
            }
        }
    }
}
