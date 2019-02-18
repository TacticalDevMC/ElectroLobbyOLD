package me.joran.electronicmc.managers.mediamanager;

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

public class MediaGUIManager {

    // Discord Media
    public static String discord_item_name = ChatUtils.format("&7&kdd&9&l&nDiscord&7&kdd");
    public static ItemStack discord_item  = null;
    // Instagram Media
    public static String instagram_item_name = ChatUtils.format("&7&kdd&9&l&nInstagram&7&kdd");
    public static ItemStack instagram_item = null;
    // Twitter Media
    public static String twitter_item_name = ChatUtils.format("&7&kdd&9&l&nTwitter&7&kdd");
    public static ItemStack twitter_item = null;
    // Youtube Media
    public static String youtube_item_name = ChatUtils.format("&7&kdd&9&l&nYoutube&7&kdd");
    public static ItemStack youtube_item = null;

    public static String media_inventory_name = ChatUtils.format("&9&lMEDIA");

    public void openMedia(Player p) {

        Inventory inv = Bukkit.createInventory(null, 36, media_inventory_name);

        // Discord
        ItemStack discord = new ISGen(Material.SKULL_ITEM, 1, (short)3).setOwner("crashdummie99").setDisplayName(discord_item_name).addItemFlags(ItemFlag.HIDE_ATTRIBUTES).getItem();
        ItemMeta discordMeta = discord.getItemMeta();
        discordMeta.setDisplayName(discord_item_name);
        ArrayList<String> discordLore = new ArrayList<>();
        discordLore.add(" ");
        discordLore.add(ChatUtils.format("&7Onze discord is: &6&lhttps://goo.gl/c9xiv3"));
        discordLore.add(" ");

        discordMeta.setLore(discordLore);
        discord.setItemMeta(discordMeta);

        // Insta
        ItemStack insta = new ISGen(Material.SKULL_ITEM, 1, (short)3).setOwner("ToolzBox").setDisplayName(instagram_item_name).getItem();
        ItemMeta instaMeta = insta.getItemMeta();
        instaMeta.setDisplayName(instagram_item_name);
        ArrayList<String> instaLore = new ArrayList<>();
        instaLore.add(" ");
        instaLore.add(ChatUtils.format("&7Onze instagram is &6&lhttps://goo.gl/9EGXAk"));
        instaLore.add(" ");

        instaMeta.setLore(instaLore);
        insta.setItemMeta(instaMeta);

        // Twitter
        ItemStack twitter = new ISGen(Material.SKULL_ITEM, 1, (short)3).setOwner("Omanoctoa").setDisplayName(twitter_item_name).getItem();
        ItemMeta twitterMeta = twitter.getItemMeta();
        twitterMeta.setDisplayName(twitter_item_name);
        ArrayList<String> twitterLore = new ArrayList<>();
        twitterLore.add(" ");
        twitterLore.add(ChatUtils.format("&7Onze twitter is &6&lhttps://goo.gl/AZk2j6"));
        twitterLore.add(" ");

        twitterMeta.setLore(twitterLore);
        twitter.setItemMeta(twitterMeta);

        // Youtube
        ItemStack youtube = new ISGen(Material.SKULL_ITEM, 1, (short)3).setOwner("MHF_YouTube").setDisplayName(youtube_item_name).getItem();
        ItemMeta youtubeMeta = youtube.getItemMeta();
        twitterMeta.setDisplayName(youtube_item_name);
        ArrayList<String> youtubeLore = new ArrayList<>();
        youtubeLore.add(" ");
        youtubeLore.add(ChatUtils.format("&7Onze youtube is &6&lhttps://goo.gl/YYXB2D"));
        youtubeLore.add(" ");

        youtubeMeta.setLore(youtubeLore);
        youtube.setItemMeta(youtubeMeta);

        discord_item = discord;
        instagram_item = insta;
        twitter_item = twitter;
        youtube_item = youtube;

        inv.setItem(11, discord);
        inv.setItem(15, insta);
        inv.setItem(21, twitter);
        inv.setItem(23, youtube);

        p.openInventory(inv);
    }

}
