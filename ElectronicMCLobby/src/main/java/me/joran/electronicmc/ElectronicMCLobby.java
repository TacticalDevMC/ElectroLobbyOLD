package me.joran.electronicmc;

import me.joran.electronicmc.commands.ElectronicMCLobbyCommand;
import me.joran.electronicmc.events.*;
import me.joran.electronicmc.events.mediaevents.MediaInventoryClickEvent;
import me.joran.electronicmc.events.npcsysteem.playerNPCClickEvent;
import me.joran.electronicmc.events.profielevents.indexProfielPlayerInventoryClickEvent;
import me.joran.electronicmc.events.profielevents.profielPlayerInventoryClickEvent;
import me.joran.electronicmc.events.serverselectorevents.selectorPlayerInventoryClickEvent;
import me.joran.electronicmc.events.settingsevents.settingsPlayerInventoryClickEvent;
import me.joran.electronicmc.managers.FileManager;
import me.joran.electronicmc.utility.ChatUtils;
import me.joran.electronicmc.utility.ConfigManager;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public final class ElectronicMCLobby extends JavaPlugin {

    private static ElectronicMCLobby instance;

    File ElectronicMCLobby = new File("plugins/ElectronicMCLobby");

    ConfigManager cfgm = new ConfigManager();


    @Override
    public void onEnable() {

        if (!ElectronicMCLobby.exists()) {
            ElectronicMCLobby.mkdir();
        }

        instance = this;
        Bukkit.getConsoleSender().sendMessage(ChatUtils.prefix + "De ElectronicMC - Lobby plugin staat aan. V" + this.getDescription().getVersion() + " Author: " + this.getDescription().getAuthors());
        registerCommands();
        registerListeners(getServer().getPluginManager());
        registerMenus();
        setupConfigManager();
        getServer().getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");

//        for (Player all : Bukkit.getOnlinePlayers()) {
//            if (!Lists.chatToggle.isEmpty()) {
//                Lists.chatToggle.remove(all.getUniqueId().toString());
//            } else {
//                Lists.chatToggle.remove(all.getUniqueId().toString());
//            }
//        }

        // main
        FileManager.load(this, "info.yml");

        //data
        FileManager.load(this, "data/npcData.yml");
        FileManager.load(this, "data/playerData.yml");

//        //whitelist
//        FileManager.load(this, "whitelist/whitelistConfigData.yml");
//        FileManager.load(this, "whitelist/whitelistUsers.yml");
    }

    @Override
    public void onDisable() {
        Bukkit.getConsoleSender().sendMessage(ChatUtils.prefix + "De ElectronicMC - Lobby plugin staat uit. V" + this.getDescription().getVersion() + " Author: " + this.getDescription().getAuthors());
        setupConfigManager();
    }

    public static ElectronicMCLobby getInstance() {
        return instance;
    }

    private void registerCommands() {
        getCommand("electroniclobby").setExecutor(new ElectronicMCLobbyCommand());
//        getCommand("test").setExecutor(new TestCommand());
    }

    private void registerListeners(PluginManager pm) {
        pm.registerEvents(new PlayerJoinQuitEvent(), this);
        pm.registerEvents(new onPlayerIntaractEvent(), this);
        pm.registerEvents(new onFoodChangeEvent(), this);
        pm.registerEvents(new onPlayerDamageEvent(), this);
        pm.registerEvents(new onPlayerChatEvent(), this);
        pm.registerEvents(new onPlayerBedEnterEvent(), this);
        pm.registerEvents(new playerJumpPad(), this);
        pm.registerEvents(new playerFirstJoinEvent(), this);
        pm.registerEvents(new playerDropPickEvent(), this);

        // selectorEvents
        pm.registerEvents(new selectorPlayerInventoryClickEvent(), this);

        // profielevents
        pm.registerEvents(new profielPlayerInventoryClickEvent(), this);
        pm.registerEvents(new indexProfielPlayerInventoryClickEvent(), this);

        // settingsevents
        pm.registerEvents(new settingsPlayerInventoryClickEvent(), this);

        // mediaevents
        pm.registerEvents(new MediaInventoryClickEvent(), this);



        // NPCSYSTEEM
        pm.registerEvents(new playerNPCClickEvent(), this);
    }

    private void setupConfigManager() {
        cfgm = new ConfigManager();
        cfgm.setup();
    }

    private void registerMenus() {}
}
