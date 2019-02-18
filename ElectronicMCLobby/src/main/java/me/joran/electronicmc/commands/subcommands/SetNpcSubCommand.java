package me.joran.electronicmc.commands.subcommands;

import me.joran.electronicmc.ElectronicMCLobby;
import me.joran.electronicmc.managers.FileManager;
import me.joran.electronicmc.utility.ChatUtils;
import net.citizensnpcs.api.CitizensAPI;
import net.citizensnpcs.api.npc.NPC;
import net.citizensnpcs.api.npc.NPCRegistry;
import net.citizensnpcs.api.trait.Trait;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

public class SetNpcSubCommand extends Trait {

    public SetNpcSubCommand(String name) {
        super(name);
    }

    public Integer npcInt = 0;

    public void onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player player = (Player) sender;

        if (args.length == 1) {
            ChatUtils.sendMessage(player, "&a&lGebruik /electroniclobby setnpc <npc>");
            ChatUtils.sendMessage(player, "&7----");
            ChatUtils.sendMessage(player, "&c&lDoe /electroniclobby help");
            ChatUtils.sendMessage(player, "&7----");
        } else if (args.length == 2) {

            if (args[1].equalsIgnoreCase("minetopia")) {

                Location loc = player.getLocation();

                World wereld = loc.getWorld();
                double x = loc.getX();
                double y = loc.getY();
                double z = loc.getZ();
                double pitch = loc.getPitch();
                double yaw = loc.getYaw();

                FileManager.get("data/npcData.yml").set("Informatie." + "MINETOPIANPC" + ".Naam", "Minetopia");
                FileManager.get("data/npcData.yml").set("Informatie." + "MINETOPIANPC" + ".Wereld", wereld.getName());
                FileManager.get("data/npcData.yml").set("Informatie." + "MINETOPIANPC" + ".Locatie" + ".X", x);
                FileManager.get("data/npcData.yml").set("Informatie." + "MINETOPIANPC" + ".Locatie" + ".Y", y);
                FileManager.get("data/npcData.yml").set("Informatie." + "MINETOPIANPC" + ".Locatie" + ".Z", z);
                FileManager.get("data/npcData.yml").set("Informatie." + "MINETOPIANPC" + ".Locatie" + ".Pitch", pitch);
                FileManager.get("data/npcData.yml").set("Informatie." + "MINETOPIANPC" + ".Locatie" + ".Yaw", yaw);
                FileManager.get("data/npcData.yml").set("Informatie." + "MINETOPIANPC" + ".GeplaatstDoor", player.getName());
                FileManager.get("data/npcData.yml").set("Informatie." + "MINETOPIANPC" + ".ProjectLeider", "BeFlexoZ");
                FileManager.save(ElectronicMCLobby.getInstance(), "data/npcData.yml");

                NPCRegistry registry = CitizensAPI.getNPCRegistry();
                NPC npc = registry.createNPC(EntityType.PLAYER, ChatUtils.format("&1M&9inetopia"));

                npc.spawn(player.getLocation());
                Bukkit.dispatchCommand(player, "npc sel");
                Bukkit.dispatchCommand(player, "npc skin " + FileManager.get("data/npcData.yml").get("Informatie." + "MINETOPIANPC" + ".ProjectLeider"));
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "citizens save");
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "citizens reload");

                ChatUtils.sendMessage(player, "&7&lU hebt de npc van Minetopia geplaatst");

                // TODO: Hologram adden

            } else if (args[1].equalsIgnoreCase("kingdom")) {

                Location loc = player.getLocation();

                World wereld = loc.getWorld();
                double x = loc.getX();
                double y = loc.getY();
                double z = loc.getZ();
                double pitch = loc.getPitch();
                double yaw = loc.getYaw();

                FileManager.get("data/npcData.yml").set("Informatie." + "KINGDOMNPC" + ".Naam", "Kingdom");
                FileManager.get("data/npcData.yml").set("Informatie." + "KINGDOMNPC" + ".Wereld", wereld.getName());
                FileManager.get("data/npcData.yml").set("Informatie." + "KINGDOMNPC" + ".Locatie" + ".X", x);
                FileManager.get("data/npcData.yml").set("Informatie." + "KINGDOMNPC" + ".Locatie" + ".Y", y);
                FileManager.get("data/npcData.yml").set("Informatie." + "KINGDOMNPC" + ".Locatie" + ".Z", z);
                FileManager.get("data/npcData.yml").set("Informatie." + "KINGDOMNPC" + ".Locatie" + ".Pitch", pitch);
                FileManager.get("data/npcData.yml").set("Informatie." + "KINGDOMNPC" + ".Locatie" + ".Yaw", yaw);
                FileManager.get("data/npcData.yml").set("Informatie." + "KINGDOMNPC" + ".GeplaatstDoor", player.getName());
                FileManager.get("data/npcData.yml").set("Informatie." + "KINGDOMNPC" + ".ProjectLeider", "iPacks");
                FileManager.save(ElectronicMCLobby.getInstance(), "data/npcData.yml");


                NPCRegistry registry = CitizensAPI.getNPCRegistry();
                NPC npc = registry.createNPC(EntityType.PLAYER, ChatUtils.format("&1K&9ingdom"));

                npc.spawn(player.getLocation());
                Bukkit.dispatchCommand(player, "npc sel");
                Bukkit.dispatchCommand(player, "npc skin " + FileManager.get("data/npcData.yml").get("Informatie." + "KINGDOMNPC" + ".ProjectLeider"));
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "citizens save");
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "citizens reload");

                ChatUtils.sendMessage(player, "&7&lU hebt de npc van Kingdom geplaatst.");

                // TODO: Hologram adden

            }
        }
    }
}
