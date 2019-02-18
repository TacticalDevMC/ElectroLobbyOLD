package me.joran.electronicmc.events.profielevents;

import me.joran.electronicmc.managers.profielmanager.ProfielGUIManager;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class profielPlayerInventoryClickEvent implements Listener {

    @EventHandler
    public void onInventoryClickEvent(InventoryClickEvent event) {
        Player p = (Player) event.getWhoClicked();
        String title = event.getInventory().getTitle();

        event.setCancelled(true);

        if (title.equalsIgnoreCase(ProfielGUIManager.profiel_inventory_name)) {
            event.setCancelled(true);

            if (event.getClickedInventory().getType() == null) return;

            if (event.getClickedInventory().getItem(event.getSlot()).isSimilar(ProfielGUIManager.sluit_item)) {
                p.closeInventory();
            }
        }
    }
}
