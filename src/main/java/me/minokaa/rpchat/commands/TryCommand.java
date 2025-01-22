package me.minokaa.rpchat.commands;

import me.minokaa.rpchat.RPChat;
import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Random;

public class TryCommand implements CommandExecutor {
    private final RPChat plugin;

    public TryCommand(RPChat plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) return true;


        Player player = (Player) sender;
        String name = player.getName();
        World world = player.getWorld();
        Player[] playersAll = world.getPlayers().toArray(new Player[0]);
        Random rand = new Random();
        int num = rand.nextInt(10);
        String action = String.join(" ", args);

        if (args.length == 0) {
            player.sendMessage(ChatColor.RED + "Введите действие");
            return true;
        }
        if (command.getName().equalsIgnoreCase("try")) {
            for (Player i : playersAll) {
                if (num <= 3) {
                    if (player.getLocation().distance(i.getLocation()) <= 20d) {
                        i.sendMessage( ChatColor.GOLD + "* " + name + " " + action + " [" + ChatColor.GREEN + "Удачно" + ChatColor.GOLD + "]");
                        System.out.println("* " + name + " " + action + "[Удачно]");
                    }
                } else if (num >=4 ) {
                    if (player.getLocation().distance(i.getLocation()) <= 20d) {
                        i.sendMessage( ChatColor.GOLD + "* " + name + " " + action + " [" + ChatColor.RED + "Неудачно" + ChatColor.GOLD + "]");
                        System.out.println("* " + name + " " + action + "[Неудачно]");
                    }
                }
            }
        }
        return true;
    }
}

