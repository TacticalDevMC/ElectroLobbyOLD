package me.joran.electronicmc.events.mediaevents;

import me.joran.electronicmc.managers.mediamanager.MediaGUIManager;
import me.joran.electronicmc.utility.ChatUtils;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class MediaInventoryClickEvent implements Listener {

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        Player p = (Player) event.getWhoClicked();
        String title = event.getInventory().getTitle();

        event.setCancelled(true);

        if (title.equalsIgnoreCase(MediaGUIManager.media_inventory_name)) {
            event.setCancelled(true);

            if (event.getClickedInventory().getType() == null) return;

            if (event.getClickedInventory().getItem(event.getSlot()).isSimilar(MediaGUIManager.discord_item)) {
                ChatUtils.sendMessage(p, "&7&lOnze discord server kun je nu joinen via https://goo.gl/c9xiv3");
            }
        }
    }
}
