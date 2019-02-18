package me.joran.electronicmc.managers.profielmanager;

import me.joran.electronicmc.api.ISGen;
import me.joran.electronicmc.utility.ChatUtils;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import ru.tehkode.permissions.bukkit.PermissionsEx;

import java.util.ArrayList;

public class ProfielGUIManager {

    private String naam_item_name = ChatUtils.format("&3Uw Naam");
    private String rank_item_name = ChatUtils.format("&3Uw Rank");
    private String online_item_name = ChatUtils.format("&3Online Spelers");
    private String server_item_name = ChatUtils.format("&3Server");
    private String sluit_item_name = ChatUtils.format("&c&lSluit Menu");
    public static ItemStack naam_item = null;
    public static ItemStack rank_item = null;
    public static ItemStack online_item = null;
    public static ItemStack server_item = null;
    public static ItemStack sluit_item = null;

    // ●

    public static String profiel_inventory_name = "§9§lPROFIEL";

    public void openProfiel(Player p) {

        Inventory inv = Bukkit.createInventory(null, 36, profiel_inventory_name);

        ItemStack playerName = new ISGen(Material.SKULL_ITEM, 1, (short)3).setOwner(p.getName()).setDisplayName(naam_item_name).getItem();
        ItemMeta playerName_meta = playerName.getItemMeta();
        playerName_meta.setDisplayName(naam_item_name);
        ArrayList<String> lore = new ArrayList<>();
        lore.add(" ");
        lore.add(ChatUtils.format("&7Naam: &9&l" + p.getName()));
        lore.add(" ");

        playerName_meta.setLore(lore);
        playerName.setItemMeta(playerName_meta);

        ItemStack rank = new ISGen(Material.SKULL_ITEM, 1, (short)3).setOwner("Mikano").setDisplayName(rank_item_name).getItem();
        ItemMeta rank_meta = rank.getItemMeta();
        rank_meta.setDisplayName(rank_item_name);
        ArrayList<String> lore2 = new ArrayList<>();
        lore2.add(" ");
        lore2.add(ChatUtils.format("&7Rank: &9&l" + PermissionsEx.getUser(p.getName()).getPrefix(p.getWorld().toString())));
        lore2.add(" ");

        rank_meta.setLore(lore2);
        rank.setItemMeta(rank_meta);

        ItemStack online = new ISGen(Material.SKULL_ITEM, 1, (short)3).setOwner("MHF_Chest").setDisplayName(online_item_name).getItem();
        ItemMeta onlineMeta = online.getItemMeta();
        onlineMeta.setDisplayName(online_item_name);
        ArrayList<String> lore3 = new ArrayList<>();
        lore3.add(" ");
        lore3.add(ChatUtils.format("&7Totaal online spelers: &9&l" + Bukkit.getServer().getOnlinePlayers().size()));
        lore3.add(" ");

        onlineMeta.setLore(lore3);
        online.setItemMeta(onlineMeta);

        ItemStack server = new ISGen(Material.WOOL, 1, (short)14).setDisplayName(server_item_name).getItem();
        ItemMeta serverMeta = server.getItemMeta();
        serverMeta.setDisplayName(server_item_name);
        ArrayList<String> lore4 = new ArrayList<>();
        lore4.add(" ");
        lore4.add(ChatUtils.format("&7U bevindt zich in de server: &9&lLobby"));
        lore4.add(" ");

        serverMeta.setLore(lore4);
        server.setItemMeta(serverMeta);

        ItemStack sluit = new ISGen(Material.BARRIER, 1).setDisplayName(sluit_item_name).getItem();
        ItemMeta sluitMeta = sluit.getItemMeta();
        sluitMeta.setDisplayName(sluit_item_name);
        ArrayList<String> sluitLore = new ArrayList<>();
        sluitLore.add(" ");
        sluitLore.add(ChatUtils.format("&7Klik om het menu te sluiten."));
        sluitLore.add(" ");

        sluitMeta.setLore(sluitLore);
        sluit.setItemMeta(sluitMeta);

        naam_item = playerName;
        rank_item = rank;
        online_item = online;
        server_item = server;
        sluit_item = sluit;

        inv.setItem(4, sluit);
        inv.setItem(11, playerName);
        inv.setItem(15, rank);
        inv.setItem(21, online);
        inv.setItem(23, server);
        p.openInventory(inv);
    }
}
