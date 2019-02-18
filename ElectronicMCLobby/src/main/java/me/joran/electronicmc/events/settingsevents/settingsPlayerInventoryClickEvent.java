package me.joran.electronicmc.events.settingsevents;

import me.joran.electronicmc.ElectronicMCLobby;
import me.joran.electronicmc.managers.FileManager;
import me.joran.electronicmc.managers.profielmanager.ProfielSettingsGUIManager;
import me.joran.electronicmc.utility.ChatUtils;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class settingsPlayerInventoryClickEvent implements Listener {



    // CHATTOGGLE
    @EventHandler
    public void onInventoryClickEvent(InventoryClickEvent event) {
        Player p = (Player) event.getWhoClicked();
        String title = event.getInventory().getTitle();

        event.setCancelled(true);

        if (event.getClickedInventory().getType() == null) return;

        if (title.equalsIgnoreCase(ProfielSettingsGUIManager.settingsProfiel_inventory_name)) {
            event.setCancelled(true);

            if (event.getClickedInventory().getItem(event.getSlot()).isSimilar(ProfielSettingsGUIManager.chatToggle_uit_item)) {

                FileManager.get("data/playerData.yml").set("Spelers." + p.getUniqueId() + ".Settings." + "ChatToggled", "Uit");
                FileManager.save(ElectronicMCLobby.getInstance(), "data/playerData.yml");
                ChatUtils.sendMessage(p, "&7&lUw chat staat nu &4&luit&7&l.");

                ProfielSettingsGUIManager.inv.setItem(11, ProfielSettingsGUIManager.chatToggle_aan_item);
            } else if (event.getClickedInventory().getItem(event.getSlot()).isSimilar(ProfielSettingsGUIManager.chatToggle_aan_item)) {

                FileManager.get("data/playerData.yml").set("Spelers." + p.getUniqueId() + ".Settings." + "ChatToggled", "Aan");
                FileManager.save(ElectronicMCLobby.getInstance(), "data/playerData.yml");
                ChatUtils.sendMessage(p, "&7&lUw chat staat nu &2&laan&7&l.");

                ProfielSettingsGUIManager.inv.setItem(11, ProfielSettingsGUIManager.chatToggle_uit_item);
            }
        }
    }
}
