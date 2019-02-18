package me.joran.electronicmc.events.profielevents;

import me.joran.electronicmc.managers.profielmanager.IndexGUIManager;
import me.joran.electronicmc.managers.profielmanager.ProfielGUIManager;
import me.joran.electronicmc.managers.profielmanager.ProfielSettingsGUIManager;
import me.joran.electronicmc.utility.ChatUtils;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class indexProfielPlayerInventoryClickEvent implements Listener {

    @EventHandler
    public void onInventoryClickEvent(InventoryClickEvent event) {
        Player p = (Player) event.getWhoClicked();
        String title = event.getInventory().getTitle();

        event.setCancelled(true);

        if (title.equalsIgnoreCase(IndexGUIManager.index_inventory_name)) {
            event.setCancelled(true);

            if (event.getClickedInventory().getType() == null) return;

            if (event.getClickedInventory().getItem(event.getSlot()).isSimilar(IndexGUIManager.profiel_item)) {
                new ProfielGUIManager().openProfiel(p);
                ChatUtils.sendMessage(p, "&a&lU opent nu uw profiel.");
            } else if (event.getClickedInventory().getItem(event.getSlot()).isSimilar(IndexGUIManager.sluit_item)) {
                p.closeInventory();
            } else if (event.getClickedInventory().getItem(event.getSlot()).isSimilar(IndexGUIManager.settings_item)) {
                new ProfielSettingsGUIManager().openSettings(p);
                ChatUtils.sendMessage(p, "&a&lU opent uw settings.");
            }
        }
    }
}
