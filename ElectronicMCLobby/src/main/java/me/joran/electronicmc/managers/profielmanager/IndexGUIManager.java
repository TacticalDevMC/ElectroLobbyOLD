package me.joran.electronicmc.managers.profielmanager;

import me.joran.electronicmc.api.ISGen;
import me.joran.electronicmc.utility.ChatUtils;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class IndexGUIManager {

    public static String profiel_item_name = ChatUtils.format("&3&lProfiel");
    public static String settings_item_name = ChatUtils.format("&3&lSettings");
    public static String sluit_item_name = ChatUtils.format("&c&lSluit Menu");

    public static ItemStack profiel_item = null;
    public static ItemStack settings_item = null;
    public static ItemStack sluit_item = null;

    public static String index_inventory_name = ChatUtils.format("&9&lINDEX");

    public void openIndex(Player p) {

        Inventory inv = Bukkit.createInventory(null, 9, index_inventory_name);


        ItemStack profiel = new ISGen(Material.BOOK).setDisplayName(profiel_item_name).getItem();
        ItemMeta profiel_meta = profiel.getItemMeta();
        profiel_meta.setDisplayName(profiel_item_name);
        ArrayList<String> profielLore = new ArrayList<>();
        profielLore.add(" ");
        profielLore.add(ChatUtils.format("&7Klik om naar je profiel te gaan."));
        profielLore.add(" ");

        profiel_meta.setLore(profielLore);
        profiel.setItemMeta(profiel_meta);

        ItemStack settings = new ISGen(Material.NETHER_STAR).setDisplayName(settings_item_name).getItem();
        ItemMeta settingsMeta = settings.getItemMeta();
        settingsMeta.setDisplayName(settings_item_name);
        ArrayList<String> settingsLore = new ArrayList<>();
        settingsLore.add(" ");
        settingsLore.add(ChatUtils.format("&7Klik om naar je settings te gaan."));
        settingsLore.add(" ");

        settingsMeta.setLore(settingsLore);
        settings.setItemMeta(settingsMeta);

        ItemStack sluit = new ISGen(Material.BARRIER, 1).setDisplayName(sluit_item_name).getItem();
        ItemMeta sluitMeta = sluit.getItemMeta();
        sluitMeta.setDisplayName(sluit_item_name);
        ArrayList<String> sluitLore = new ArrayList<>();
        sluitLore.add(" ");
        sluitLore.add(ChatUtils.format("&7Klik om het menu te sluiten."));
        sluitLore.add(" ");

        sluitMeta.setLore(sluitLore);
        sluit.setItemMeta(sluitMeta);

        profiel_item = profiel;
        settings_item = settings;
        sluit_item = sluit;

        inv.setItem(3, profiel);
        inv.setItem(4, sluit);
        inv.setItem(5, settings);

        p.openInventory(inv);

    }
}
