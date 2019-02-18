package me.joran.electronicmc.utility;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class ChatUtils {

    public static String format(String message) {
        return ChatColor.translateAlternateColorCodes('&', message);
    }

    public static String prefix = ChatUtils.format("&1&lE&9&llectronic&1&lMC &a>> ");

    public static String geenpermissions = ChatUtils.format(ChatUtils.prefix + "&c&lU hebt geen permissions om deze actie uittevoeren.");

    public static void sendMessage(Player player, String message) {
        player.sendMessage(ChatUtils.format(ChatUtils.prefix + message));
    }

    public static void debug(String debugMessage, Class cl) {
        Bukkit.getConsoleSender().sendMessage("[DEBUG] Message: " + debugMessage + " Class: " + cl.getSimpleName() + ".java");
    }

    public static void error(String errorMessage, Class cl) {
        Bukkit.getConsoleSender().sendMessage("[ERROR] Message: " + errorMessage + " Class: " + cl.getSimpleName() + ".java");
    }
}
