package me.joran.electronicmc.events.npcsysteem;

import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;
import me.joran.electronicmc.ElectronicMCLobby;
import me.joran.electronicmc.utility.ChatUtils;
import net.citizensnpcs.api.event.NPCClickEvent;
import net.citizensnpcs.api.npc.NPC;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class playerNPCClickEvent implements Listener {

    @EventHandler
    public void ClickEventOnNPC(NPCClickEvent event) {
        Player p = event.getClicker();
        NPC npc = event.getNPC();


        if (npc.getName().equalsIgnoreCase("&1M&9inetopia")) {
            send(p, "minetopia");
            ChatUtils.sendMessage(p, ChatUtils.prefix + "&c&lU wordt verstuurd naar de Minetopia server.");
        } else if (npc.getName().equalsIgnoreCase("&1K&9ingdom")) {
            send(p, "kingdom");
            ChatUtils.sendMessage(p, ChatUtils.prefix + "&c&lU wordt verstuurd naar de Minetopia server.");
        }
    }

//    @EventHandler
//    public void NPCClickEvent(NPCRightClickEvent event) {
//        Player p = event.getClicker();
//        NPC npc = event.getNPC();
//
//
//        if (npc.getName().equalsIgnoreCase("&1M&9inetopia")) {
//            send(p, "minetopia");
//            ChatUtils.sendMessage(p, ChatUtils.prefix + "&c&lU wordt verstuurd naar de Minetopia server.");
//        } else if (npc.getName().equalsIgnoreCase("&1K&9ingdom")) {
//            send(p, "kingdom");
//            ChatUtils.sendMessage(p, ChatUtils.prefix + "&c&lU wordt verstuurd naar de Minetopia server.");
//        }
//    }

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
