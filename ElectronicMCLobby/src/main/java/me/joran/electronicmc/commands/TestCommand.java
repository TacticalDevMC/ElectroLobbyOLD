package me.joran.electronicmc.commands;

import me.joran.electronicmc.utility.ChatUtils;
import me.joran.electronicmc.utility.NPC;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@SuppressWarnings("ALL")
public class TestCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player player = (Player) sender;

        if (cmd.getName().equalsIgnoreCase("test")) {
            NPC npc = new NPC(player.getLocation(), ChatUtils.format("&cItsJustJoran"));

            npc.spawn();

            this.showNPCToAll(npc);
        }
        return false;
    }

    public void showNPC(NPC npc, Player player) {
        npc.show(player);
    }

    public void showNPCToAll(NPC npc) {
        for (Player player : Bukkit.getOnlinePlayers()) {
            this.showNPC(npc, player);
        }
    }
}
