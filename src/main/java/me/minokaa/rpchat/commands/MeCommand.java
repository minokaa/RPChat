package me.minokaa.rpchat.commands;

import me.minokaa.rpchat.RPChat;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import java.util.Arrays;

public class MeCommand implements CommandExecutor {
    private final RPChat plugin;

    public MeCommand(RPChat plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) return true;

        Player player = (Player) sender;
        String name = player.getName();
        World world = player.getWorld();
        Player[] playersAll = world.getPlayers().toArray(new Player[0]);
        String action = String.join(" ", args);
        FileConfiguration config = RPChat.getPlugin().getConfig();
        String color = config.getString("color-commands.me");
        String language = config.getString("language");

        color = ChatColor.translateAlternateColorCodes('&', color);

        if (language.equals("RU")) {
            if (args.length == 0) {
                player.sendMessage(ChatColor.RED + "Введите действие");
                return true;
            }
            if (command.getName().equalsIgnoreCase("me")) {
                for (Player i : playersAll) {
                    if (player.getLocation().distance(i.getLocation()) <= 20d) {
                        i.sendMessage(color + "* " + name + " " + action);
                        System.out.println("* " + name + " " + action);
                    }
                }
            }
        } else if (language.equals("EN")) {
            if (args.length == 0) {
                player.sendMessage(ChatColor.RED + "Enter the action");
                return true;
            }

            if (command.getName().equalsIgnoreCase("me")) {
                for (Player i : playersAll) {
                    if (player.getLocation().distance(i.getLocation()) <= 20d) {
                        i.sendMessage(color + "* " + name + " " + action);
                        System.out.println("* " + name + " " + action);
                    }
                }
            }
        }
        return true;
    }
}