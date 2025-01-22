package me.minokaa.rpchat.chat;

import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChatEvent;

public class RpChat implements Listener {

    @EventHandler
    public boolean onChat(PlayerChatEvent e) {

        Player player = e.getPlayer();
        String namePlayer = player.getName();
        World world = e.getPlayer().getWorld();
        String message = e.getMessage();
        Player playersAll[] = world.getPlayers().toArray(new Player[0]);

        if (message.toCharArray()[0] == '!' && message.length() != 1) {
            message = message.substring(1);
            for (Player i : playersAll) {
                if (player.getLocation().distance(i.getLocation()) <= 60d) {
                    i.sendMessage(namePlayer + ChatColor.GOLD + ChatColor.BOLD + " кричит: " + ChatColor.RESET + message);
                    System.out.println(namePlayer + " кричит: " + message);

                }
            }
        } else if (message.toCharArray()[0] == ',' && message.length() != 1) {
            message = message.substring(1);
            for (Player i : playersAll) {
                if (player.getLocation().distance(i.getLocation()) <= 3d) {
                    i.sendMessage(namePlayer + ChatColor.DARK_GRAY + " шепчет: " + ChatColor.RESET + message);
                    System.out.println(namePlayer + " шепчет: " + message);
                }
            }
        } else if (message.toCharArray()[0] == '_' && message.length() != 1) {
            message = message.substring(1);
            for (Player i : playersAll) {
                if (player.getLocation().distance(i.getLocation()) <= 20d) {
                    i.sendMessage( ChatColor.AQUA + namePlayer + ": ((" + message + "))");
                    System.out.println(namePlayer + ": (( " + message + "))");
                }
            }
        } else {
            for (Player i : playersAll) {
                if (player.getLocation().distance(i.getLocation()) <= 20d) {
                    i.sendMessage(namePlayer + ChatColor.GRAY + " говорит: " + ChatColor.RESET + message);
                    System.out.println(namePlayer + " говорит: " + message);
                }
            }
        }
        e.setCancelled(true);
        return true;
    }
}