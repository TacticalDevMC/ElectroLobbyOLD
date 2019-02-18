package me.joran.electronicmc.events.serverselectorevents;

import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;
import me.joran.electronicmc.ElectronicMCLobby;
import me.joran.electronicmc.managers.serverselectormanager.ServerSelectorGUIManager;
import me.joran.electronicmc.utility.ChatUtils;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class selectorPlayerInventoryClickEvent implements Listener {

    @EventHandler
    public void onInventoryClickEvent(InventoryClickEvent event) {
        Player p = (Player) event.getWhoClicked();
        String title = event.getInventory().getTitle();

        event.setCancelled(true);


        if (title.equalsIgnoreCase(ServerSelectorGUIManager.serverselector_inventory_name)) {
            event.setCancelled(true);

//            if(p.getInventory().getItem(event.getSlot()) == null) return;

            if (event.getClickedInventory().getItem(event.getSlot()).isSimilar(ServerSelectorGUIManager.minetopia_item)) {
                send(p, "minetopia");
                ChatUtils.sendMessage(p, "&a&lU wordt verstuurd naar de server &b&lMINETOPIA&a&l.");
            } else if (event.getClickedInventory().getItem(event.getSlot()).isSimilar(ServerSelectorGUIManager.kingdom_item)) {
                send(p, "kingdom");
                ChatUtils.sendMessage(p, "&a&lU wordt verstuurd naar de server &b&lKINGDOM&a&l.");
            }
        }
    }


    private void send(Player p, String server){
        try {
            ByteArrayDataOutput out = ByteStreams.newDataOutput();
            out.writeUTF("Connect");
            out.writeUTF(server);
            p.sendPluginMessage(ElectronicMCLobby.getPlugin(ElectronicMCLobby.class), "BungeeCord", out.toByteArray());
        } catch (Exception e) {
            Bukkit.getLogger().info("You'll never see me!");
        }
    }
}
