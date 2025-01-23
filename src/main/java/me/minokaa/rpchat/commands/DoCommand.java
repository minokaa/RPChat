package me.minokaa.rpchat.commands;

import me.minokaa.rpchat.RPChat;
import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

public class DoCommand implements CommandExecutor {
    private final RPChat plugin;

    public DoCommand(RPChat plugin) {
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
        String color = config.getString("color-commands.do");

        color = ChatColor.translateAlternateColorCodes('&', color);

        if (args.length == 0) {
            player.sendMessage(ChatColor.RED + "Введите действие");
            return true;
        }

        if (command.getName().equalsIgnoreCase("do")) {
            for (Player i : playersAll) {
                if (player.getLocation().distance(i.getLocation()) <= 20d) {
                    i.sendMessage(  color + action + " ((" + ChatColor.DARK_GRAY + name + color + "))");
                    System.out.println(action + " ((" + name + "))");
                }
            }
        }
        return true;
    }
}
