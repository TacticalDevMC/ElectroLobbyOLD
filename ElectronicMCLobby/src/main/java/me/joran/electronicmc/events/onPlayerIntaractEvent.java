package me.joran.electronicmc.events;

import me.joran.electronicmc.api.Cooldown;
import me.joran.electronicmc.managers.mediamanager.MediaGUIManager;
import me.joran.electronicmc.managers.profielmanager.IndexGUIManager;
import me.joran.electronicmc.managers.serverselectormanager.ServerSelectorGUIManager;
import me.joran.electronicmc.utility.ChatUtils;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import ru.tehkode.permissions.bukkit.PermissionsEx;

import java.util.ArrayList;

public class onPlayerIntaractEvent implements Listener {

    public static ArrayList<String> f = new ArrayList<>();

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        Action action = event.getAction();
        ItemStack item = event.getItem();

        event.setCancelled(true);

        if (action == Action.RIGHT_CLICK_AIR || action == Action.LEFT_CLICK_AIR || action == Action.RIGHT_CLICK_BLOCK) {
            if (player.getItemInHand() == null) return;
            if (player.getItemInHand().getType().equals(Material.AIR)) return;

            if (item.getItemMeta().getDisplayName().equals(PlayerJoinQuitEvent.Profiel)) {

                if (Cooldown.isInCooldown(player.getUniqueId(), "profiel")) {
                    ChatUtils.sendMessage(player, ChatUtils.format("&c&lU moet nog &f&l" + Cooldown.getTimeLeft(player.getUniqueId(), "profiel") + " &c&lseconden wachten."));
                } else {
                    Cooldown c = new Cooldown(player.getUniqueId(), "profiel", 3);
                    c.start();

                    ChatUtils.sendMessage(player, ChatUtils.format("&a&lU hebt het index menu geopend."));
                    new IndexGUIManager().openIndex(player);
                }
            } else if (item.getItemMeta().getDisplayName().equals(PlayerJoinQuitEvent.Fly)) {
                if (PermissionsEx.getPermissionManager().getUser(player).inGroup("Diamond") || PermissionsEx.getPermissionManager().getUser(player).inGroup("Obsidian")
                        || PermissionsEx.getPermissionManager().getUser(player).inGroup("Emerald") || PermissionsEx.getPermissionManager().getUser(player).inGroup("Electro")
                        || PermissionsEx.getPermissionManager().getUser(player).inGroup("Helper") || PermissionsEx.getPermissionManager().getUser(player).inGroup("Moderator")
                        || PermissionsEx.getPermissionManager().getUser(player).inGroup("Admin") || PermissionsEx.getPermissionManager().getUser(player).inGroup("ProjectLeider")
                        || PermissionsEx.getPermissionManager().getUser(player).inGroup("StaffManager")
                        || PermissionsEx.getPermissionManager().getUser(player).inGroup("JrDeveloper") || PermissionsEx.getPermissionManager().getUser(player).inGroup("Developer")
                        || PermissionsEx.getPermissionManager().getUser(player).inGroup("Manager") || PermissionsEx.getPermissionManager().getUser(player).inGroup("Eigenaar")) {
                    if (!this.f.contains(player.getUniqueId().toString())) {
                        this.f.add(player.getUniqueId().toString());
                        player.setAllowFlight(true);
                        player.setFlying(true);
                        ChatUtils.sendMessage(player, ChatUtils.format("&a&lU hebt vliegen &2&lAAN &a&lgezet"));
                    } else if (this.f.contains(player.getUniqueId().toString())) {
                        this.f.remove(player.getUniqueId().toString());
                        player.setFlying(false);
                        player.setAllowFlight(false);
                        ChatUtils.sendMessage(player, ChatUtils.format("&c&lU hebt vliegen &4&lUIT &c&lgezet"));
                    }
                } else {
                    ChatUtils.sendMessage(player, "&c&lU hebt hier de rank &b&l&nDiamond+ &c&lvoor nodig.");
                }
            } else if (item.getItemMeta().getDisplayName().equals(PlayerJoinQuitEvent.Media)) {

                if (Cooldown.isInCooldown(player.getUniqueId(), "media")) {
                    ChatUtils.sendMessage(player, ChatUtils.format("&c&lU moet nog &f&l" + Cooldown.getTimeLeft(player.getUniqueId(), "media") + " &c&lseconden wachten."));
                } else {
                    Cooldown c = new Cooldown(player.getUniqueId(), "media", 5);
                    c.start();

                    ChatUtils.sendMessage(player, ChatUtils.format("&a&lU hebt de social media geopend."));
                    new MediaGUIManager().openMedia(player);
                }
            } else if (item.getItemMeta().getDisplayName().equals(PlayerJoinQuitEvent.ServerSelector)) {

                ChatUtils.sendMessage(player, ChatUtils.format("&a&lU hebt de serverselector geopend."));
                new ServerSelectorGUIManager().openSelector(player);
            }
        }
    }
}
