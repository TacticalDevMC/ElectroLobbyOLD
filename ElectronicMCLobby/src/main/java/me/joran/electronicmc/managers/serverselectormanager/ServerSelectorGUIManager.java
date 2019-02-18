package me.joran.electronicmc.managers.serverselectormanager;

import me.joran.electronicmc.api.ISGen;
import me.joran.electronicmc.utility.ChatUtils;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class ServerSelectorGUIManager {

    // Minetopia
    public static String minetopia_item_name = ChatUtils.format("&7&kdd&9&l&nMinetopia&7&kdd");
    public static ItemStack minetopia_item  = null;
    // Skyblock
    public static String skyblock_item_name = ChatUtils.format("&7&kdd&9&l&nSkyblock&7&kdd");
    public static ItemStack skyblock_item  = null;
    // Skyblock
    public static String kingdom_item_name = ChatUtils.format("&7&kdd&9&l&nKingdom&7&kdd");
    public static ItemStack kingdom_item  = null;
    // Glass
    public static String glass_item_name = ChatUtils.format(" ");
    public static ItemStack glass_item  = null;

    public static String serverselector_inventory_name = ChatUtils.format("&9&lSELECTOR");

    public static void openSelector(Player p) {

        Inventory inv = Bukkit.createInventory(null, 36, serverselector_inventory_name);

        ItemStack minetopia = new ISGen(Material.DIAMOND_BLOCK).setDisplayName(minetopia_item_name).addItemFlags(ItemFlag.HIDE_ATTRIBUTES).getItem();
        ItemMeta minetopiaMeta = minetopia.getItemMeta();
        minetopiaMeta.setDisplayName(minetopia_item_name);
        ArrayList<String> minetopiaLore = new ArrayList<>();
        minetopiaLore.add(" ");
        minetopiaLore.add(ChatUtils.format("&7Klik hier om naar minetopia te gaan."));
        minetopiaLore.add(" ");

        minetopiaMeta.setLore(minetopiaLore);
        minetopia.setItemMeta(minetopiaMeta);

//        ItemStack skyblock = new ISGen(Material.GRASS).setDisplayName(skyblock_item_name).addItemFlags(ItemFlag.HIDE_ATTRIBUTES).getItem();
//        ItemMeta skyblockMeta = skyblock.getItemMeta();
//        skyblockMeta.setDisplayName(skyblock_item_name);
//        ArrayList<String> skyblockLore = new ArrayList<>();
//        skyblockLore.add(" ");
//        skyblockLore.add(ChatUtils.format("&7Klik hier om naar skyblock te gaan."));
//        skyblockLore.add(" ");

//        skyblockMeta.setLore(skyblockLore);
//        skyblock.setItemMeta(skyblockMeta);

        ItemStack kingdom = new ISGen(Material.BLAZE_ROD).setDisplayName(kingdom_item_name).getItem();
        ItemMeta kingdomMeta = kingdom.getItemMeta();
        kingdomMeta.setDisplayName(kingdom_item_name);
        ArrayList<String> kingdomLore = new ArrayList<>();
        kingdomLore.add(" ");
        kingdomLore.add(ChatUtils.format("&7Klik hier om naar kingdom te gaan."));
        kingdomLore.add(" ");

        kingdomMeta.setLore(kingdomLore);
        kingdom.setItemMeta(kingdomMeta);

        ItemStack glass = new ISGen(Material.STAINED_GLASS_PANE, 1, (short)0).setDisplayName(glass_item_name).addItemFlags(ItemFlag.HIDE_ATTRIBUTES).getItem();
        ItemMeta glassMeta = glass.getItemMeta();
        glassMeta.setDisplayName(glass_item_name);

        glass.setItemMeta(glassMeta);

        minetopia_item = minetopia;
//        skyblock_item = skyblock;
        kingdom_item = kingdom;
        glass_item = glass;

        inv.setItem(0, glass);
        inv.setItem(1, glass);
        inv.setItem(2, glass);
        inv.setItem(3, glass);
        inv.setItem(4, glass);
        inv.setItem(5, glass);
        inv.setItem(6, glass);
        inv.setItem(7, glass);
        inv.setItem(8, glass);
        inv.setItem(9, glass);
        inv.setItem(10, glass);
        inv.setItem(11, minetopia);
        inv.setItem(12, glass);
        inv.setItem(13, kingdom);
        inv.setItem(14, glass);
//        inv.setItem(15, kingdom);
        inv.setItem(15, glass);
        inv.setItem(16, glass);
        inv.setItem(17, glass);
        inv.setItem(18, glass);
        inv.setItem(19, glass);
        inv.setItem(20, glass);
        inv.setItem(21, glass);
        inv.setItem(22, glass);
        inv.setItem(23, glass);
        inv.setItem(24, glass);
        inv.setItem(25, glass);
        inv.setItem(26, glass);
        inv.setItem(27, glass);
        inv.setItem(28, glass);
        inv.setItem(29, glass);
        inv.setItem(30, glass);
        inv.setItem(31, glass);
        inv.setItem(32, glass);
        inv.setItem(33, glass);
        inv.setItem(34, glass);
        inv.setItem(35, glass);


        p.openInventory(inv);
    }

}
