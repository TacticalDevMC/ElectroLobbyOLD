package me.joran.electronicmc.events;

import me.joran.electronicmc.managers.FileManager;
import me.joran.electronicmc.utility.ChatUtils;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import ru.tehkode.permissions.bukkit.PermissionsEx;

import java.util.ArrayList;
import java.util.List;

public class onPlayerChatEvent implements Listener {

    @EventHandler
    public void onChat(AsyncPlayerChatEvent event) {
        Player player = event.getPlayer();
        String message = event.getMessage();

        if (FileManager.get("data/playerData.yml").get("Spelers." + player.getUniqueId() + ".Settings." + "ChatToggled").equals("Aan")) {

            event.setFormat(ChatUtils.format(PermissionsEx.getUser(player.getName()).getPrefix(player.getWorld().toString()) + player.getName() + "&7: &f" + message));


//            if (Cooldown.isInCooldown(player.getUniqueId(), "spam")) {
//                ChatUtils.sendMessage(player, ChatUtils.format("&c&lSpammen in de chat is niet toegelaten, u moet nog &f&l" + Cooldown.getTimeLeft(player.getUniqueId(), "spam") + " &c&lseconden wachten."));
//                event.setCancelled(true);
//            } else {
//                Cooldown c = new Cooldown(player.getUniqueId(), "spam", 2);
//                c.start();
//            }

            if (message.equals("kanker") || message.equals("kkr") || message.equals("neuken") || message.equals("kut") || message.equals("homo") || message.equals("bitch")) {

                event.setFormat(ChatUtils.format(PermissionsEx.getUser(player).getPrefix(player.getWorld().toString()) + player.getName() + "&7: &f****"));
                player.sendMessage(ChatUtils.format(ChatUtils.prefix + "&c&lU hebt gescholden in de chat, dit is verboden. Gelieve NIET meer te doen."));
            }
        } else if (FileManager.get("data/playerData.yml").get("Spelers." + player.getUniqueId() + ".Settings." + "ChatToggled").equals("Uit")) {
            ChatUtils.sendMessage(player, "&c&lU kunt geen berichten sturen in de chat, u hebt uw chat uit staan.");
            event.setCancelled(true);

            List<Player> disabledChatPlayers = new ArrayList<>();
            for(Player p : disabledChatPlayers) {
                event.getRecipients().remove(p);
            }
            return;
        }
    }
}
