package me.minokaa.rpchat;

import me.minokaa.rpchat.listeners.RpChat;
import me.minokaa.rpchat.commands.DoCommand;
import me.minokaa.rpchat.commands.MeCommand;
import me.minokaa.rpchat.commands.TryCommand;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public final class RPChat extends JavaPlugin implements Listener {

    static RPChat plugin;



    @Override
    public void onEnable() {

        plugin = this;

        getConfig().options().copyDefaults();
        saveDefaultConfig();

        getServer().getPluginCommand("me").setExecutor(new MeCommand(this));
        getServer().getPluginCommand("do").setExecutor(new DoCommand(this));
        getServer().getPluginCommand("try").setExecutor(new TryCommand(this));
        getServer().getPluginManager().registerEvents(new RpChat(), this);

    }

    public static RPChat getPlugin(){
        return plugin;
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
