package me.joran.electronicmc.managers.profielmanager;

import me.joran.electronicmc.api.ISGen;
import me.joran.electronicmc.managers.FileManager;
import me.joran.electronicmc.utility.ChatUtils;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class ProfielSettingsGUIManager {

    // Chattoggle aan
    public static String chatToggle_aan_item_name = ChatUtils.format("&3&lToggle Chat >> &4&lUit");
    public static ItemStack chatToggle_aan_item = null;
    // Chattoggle uit
    public static String chatToggle_uit_item_name = ChatUtils.format("&3&lToggle Chat >> &a&lAan");
    public static ItemStack chatToggle_uit_item = null;

    public static String settingsProfiel_inventory_name = ChatUtils.format("&9&lSETTINGS");

    public static Inventory inv = Bukkit.createInventory(null, 36, settingsProfiel_inventory_name);

    public void openSettings(Player player) {

        if (FileManager.get("data/playerData.yml").get("Spelers." + player.getUniqueId() + ".Settings." + "ChatToggled").equals("Aan")) {
            ItemStack chatToggle = new ISGen(Material.INK_SACK, 1, (short)10).setDisplayName(chatToggle_uit_item_name).getItem();
            ItemMeta chatToggleMeta = chatToggle.getItemMeta();
            chatToggleMeta.setDisplayName(chatToggle_uit_item_name);
            ArrayList<String> chatToggleLore = new ArrayList<>();
            chatToggleLore.add(" ");
            chatToggleLore.add(ChatUtils.format("&7Klik hier om je chat te togglen naar &4&lUit."));
            chatToggleLore.add(" ");

            chatToggleMeta.setLore(chatToggleLore);
            chatToggle.setItemMeta(chatToggleMeta);

            chatToggle_uit_item = chatToggle;


            inv.setItem(11, chatToggle);
        } else if (FileManager.get("data/playerData.yml").get("Spelers." + player.getUniqueId() + ".Settings." + "ChatToggled").equals("Uit")) {
            ItemStack chatToggle = new ISGen(Material.INK_SACK, 1, (short)8).setDisplayName(chatToggle_aan_item_name).getItem();
            ItemMeta chatToggleMeta = chatToggle.getItemMeta();
            chatToggleMeta.setDisplayName(chatToggle_aan_item_name);
            ArrayList<String> chatToggleLore = new ArrayList<>();
            chatToggleLore.add(" ");
            chatToggleLore.add(ChatUtils.format("&7Klik hier om je chat te togglen naar &a&lAan."));
            chatToggleLore.add(" ");

            chatToggleMeta.setLore(chatToggleLore);
            chatToggle.setItemMeta(chatToggleMeta);

            chatToggle_aan_item = chatToggle;

            inv.setItem(11, chatToggle);
        }

        player.openInventory(inv);
    }
}
