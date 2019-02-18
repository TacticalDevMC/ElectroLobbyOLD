package me.joran.electronicmc.events;

import me.joran.electronicmc.ElectronicMCLobby;
import me.joran.electronicmc.api.ISGen;
import me.joran.electronicmc.managers.FileManager;
import me.joran.electronicmc.utility.ChatUtils;
import me.joran.electronicmc.utility.ConfigManager;
import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import ru.tehkode.permissions.bukkit.PermissionsEx;

import java.util.ArrayList;
import java.util.Date;

public class PlayerJoinQuitEvent implements Listener {

    public static String ServerSelector = ChatUtils.format("&1&lS&9&lerver&1&lS&9&lelector &7(Rechts/links klik)");
    public static String Media = ChatUtils.format("&1M&9edia &7(Rechts/links klik)");
    public static String Fly = ChatUtils.format("&1V&9lieg&1M&9odus &7(Rechts/links klik)");
    public static String Profiel = ChatUtils.format("&1M&9ijn&1P&9rofiel &7(Rechts/links klik)");

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();

        event.setJoinMessage(ChatUtils.format(PermissionsEx.getUser(player).getPrefix(player.getWorld().toString()) + player.getName() + " &a&lIs de server gejoined."));

        PlayerInventory pinv = player.getInventory();

        ItemStack serverselector = new ISGen(Material.COMPASS).setDisplayName(ServerSelector).addItemFlags(ItemFlag.HIDE_ATTRIBUTES).getItem();
        ItemMeta serverselectorMeta = serverselector.getItemMeta();
        serverselectorMeta.setDisplayName(ServerSelector);

        ArrayList<String> serverselectorLore = new ArrayList<>();
        serverselectorLore.add(" ");
        serverselectorLore.add(ChatUtils.format("&7Kies een gamemode"));
        serverselectorLore.add(" ");

        serverselectorMeta.setLore(serverselectorLore);
        serverselector.setItemMeta(serverselectorMeta);

        ItemStack media = new ISGen(Material.SKULL_ITEM, 1, (short) 3).setOwner("0qt").setDisplayName(Media).addItemFlags(ItemFlag.HIDE_ATTRIBUTES).getItem();
        ItemMeta MediaMeta = media.getItemMeta();
        MediaMeta.setDisplayName(Media);

        ArrayList<String> MediaLore = new ArrayList<>();
        MediaLore.add(" ");
        MediaLore.add(ChatUtils.format("&7Hierin vindt je all onze social media."));
        MediaLore.add(" ");

        MediaMeta.setLore(MediaLore);
        media.setItemMeta(MediaMeta);

        ItemStack flymode = new ISGen(Material.FEATHER).setDisplayName(Fly).addItemFlags(ItemFlag.HIDE_ATTRIBUTES).getItem();
        ItemMeta flymodeMeta = flymode.getItemMeta();
        flymodeMeta.setDisplayName(Fly);

        ArrayList<String> flymodeLore = new ArrayList<>();
        flymodeLore.add(" ");
        flymodeLore.add(ChatUtils.format("&7Klik om te kunnen vliegen."));
        flymodeLore.add(" ");

        flymodeMeta.setLore(flymodeLore);
        flymode.setItemMeta(flymodeMeta);

        ItemStack profiel = new ISGen(Material.SKULL_ITEM, 1, (short) 3).setOwner(player.getName()).setDisplayName(Profiel).addItemFlags(ItemFlag.HIDE_ATTRIBUTES).getItem();
        ItemMeta profielMeta = profiel.getItemMeta();
        profielMeta.setDisplayName(Profiel);

        ArrayList<String> profielLore = new ArrayList<>();
        profielLore.add(" ");
        profielLore.add(ChatUtils.format("&7Klik om je profiel te openen."));
        profielLore.add(" ");

        profielMeta.setLore(profielLore);
        profiel.setItemMeta(profielMeta);

        pinv.clear();
        pinv.setItem(0, profiel);
        pinv.setItem(4, serverselector);
        pinv.setItem(5, flymode);
        pinv.setItem(8, media);

        player.setGameMode(GameMode.ADVENTURE);
        player.setFoodLevel(20);
        player.setHealth(20);
        player.setExp(0);
        player.setTotalExperience(0);

        for (PotionEffect allPotionEffects : player.getActivePotionEffects()) {
            player.removePotionEffect(allPotionEffects.getType());
        }

        player.setPlayerWeather(WeatherType.CLEAR);

        World w = Bukkit.getServer().getWorld(ConfigManager.spawns.getString("spawn.world"));
        double x = ConfigManager.spawns.getDouble("spawn.x");
        double y = ConfigManager.spawns.getDouble("spawn.y");
        double z = ConfigManager.spawns.getDouble("spawn.z");
        player.teleport(new Location(w, x, y, z));

//        if (FileManager.get("data/playerDaya.yml").get("Spelers." + player.getUniqueId() + ".ChatToggled")) {
//            chatToggle.
//        }

        if (FileManager.get("data/playerData.yml").get("Spelers." + player.getUniqueId()) == null) {
            FileManager.get("data/playerData.yml").set("Spelers." + player.getUniqueId() + ".Naam", player.getName());
            FileManager.get("data/playerData.yml").set("Spelers." + player.getUniqueId() + ".GejoinedOp", new Date());
            FileManager.get("data/playerData.yml").set("Spelers." + player.getUniqueId() + ".Rank-Group", PermissionsEx.getUser(player).getPrefix(player.getLocation().getWorld().toString()));
            FileManager.get("data/playerData.yml").set("Spelers." + player.getUniqueId() + ".Settings." + "ChatToggled", "Aan");
            FileManager.save(ElectronicMCLobby.getInstance(), "data/playerData.yml");
        }
//
//        if (FileManager.get("whitelist/whitelistUsers.yml").get("Users." + player.getName()) == null) {
//            FileManager.get("whitelist/whitelistUsers.yml").set("Users." + player.getName() + ".Whitelisted", "False");
//            FileManager.save(ElectronicMCLobby.getInstance(), "whitelist/whitelistUsers.yml");
//            player.kickPlayer(ChatUtils.format("&4&lKICKED, REJOIN. We zijn uw data aan het zoeken. En aan het aanmaken."));
//        }
//
//        String whitelistMessage = FileManager.get("whitelist/whitelistConfigData.yml").get("Info." + ".message").toString().replaceAll("&", "§");
//
//        if (FileManager.get("whitelist/whitelistConfigData.yml").get("Info." + ".status").equals("Aan")) {
//            if (FileManager.get("whitelist/whitelistUsers.yml").get("Users." + player.getName() + ".Whitelisted").equals("False")) {
//                player.kickPlayer(whitelistMessage);
//                return;
//            }
//        } else if (FileManager.get("whitelist/whitelistConfigData.yml").get("Info." + ".status").equals("Uit")) {
//            return;
//        }
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent event) {
        Player player = event.getPlayer();

        event.setQuitMessage(ChatUtils.format(PermissionsEx.getUser(player.getName()).getPrefix(player.getWorld().toString()) + player.getName() + " &c&lIs de server geleaved."));
    }
}

