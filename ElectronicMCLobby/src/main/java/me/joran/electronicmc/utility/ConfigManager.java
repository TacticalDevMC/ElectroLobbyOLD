package me.joran.electronicmc.utility;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;

public class ConfigManager {

    File ElectronicMCLobby = new File("plugins/ElectronicMCLobby");

    public static FileConfiguration spawns = new YamlConfiguration();
    public static File spawnsFile = new File("plugins/ElectronicMCLobby/spawns.yml");

    public void setup() {
        if (!this.ElectronicMCLobby.exists()) {
            this.ElectronicMCLobby.mkdir();
        }

        if (!spawnsFile.exists()) {
            try {
                spawnsFile.createNewFile();
            } catch (Exception var2) {
                Bukkit.getServer().getConsoleSender().sendMessage("Er is iets mis gegaan!");
                var2.printStackTrace();
            }
        }

        try {
            spawns.load(spawnsFile);
        } catch (Exception var3) {
            Bukkit.getServer().getConsoleSender().sendMessage(ChatUtils.format(ChatUtils.prefix + "Er is iets mis gegaan!"));
            var3.printStackTrace();
        }
    }
}
