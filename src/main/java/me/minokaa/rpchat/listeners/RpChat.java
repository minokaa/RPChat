package me.minokaa.rpchat.listeners;

import me.minokaa.rpchat.RPChat;
import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.configuration.file.FileConfiguration;
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
        FileConfiguration config = RPChat.getPlugin().getConfig();
        String language = config.getString("language");

        String whisperColor = config.getString("color-chat.whisper");
        String screamColor = config.getString("color-chat.scream");
        String defaultColor = config.getString("color-chat.default");
        String loocColor = config.getString("color-chat.LOOC");

        whisperColor = ChatColor.translateAlternateColorCodes('&', whisperColor);
        screamColor = ChatColor.translateAlternateColorCodes('&', screamColor);
        defaultColor = ChatColor.translateAlternateColorCodes('&', defaultColor);
        loocColor = ChatColor.translateAlternateColorCodes('&', loocColor);

        if(language.equals("RU")) {
            if (message.toCharArray()[0] == '!' && message.length() != 1) {
                message = message.substring(1);
                for (Player i : playersAll) {
                    if (player.getLocation().distance(i.getLocation()) <= 60d) {
                        i.sendMessage(namePlayer + screamColor + " кричит: " + ChatColor.RESET + message);
                        System.out.println(namePlayer + " кричит: " + message);

                    }
                }
            } else if (message.toCharArray()[0] == ',' && message.length() != 1) {
                message = message.substring(1);
                for (Player i : playersAll) {
                    if (player.getLocation().distance(i.getLocation()) <= 3d) {
                        i.sendMessage(namePlayer + whisperColor + " шепчет: " + ChatColor.RESET + message);
                        System.out.println(namePlayer + " шепчет: " + message);
                    }
                }
            } else if (message.toCharArray()[0] == '_' && message.length() != 1) {
                message = message.substring(1);
                for (Player i : playersAll) {
                    if (player.getLocation().distance(i.getLocation()) <= 20d) {
                        i.sendMessage(loocColor + namePlayer + ": ((" + message + "))");
                        System.out.println(namePlayer + ": (( " + message + "))");
                    }
                }
            } else {
                for (Player i : playersAll) {
                    if (player.getLocation().distance(i.getLocation()) <= 20d) {
                        i.sendMessage(namePlayer + defaultColor + " говорит: " + ChatColor.RESET + message);
                        System.out.println(namePlayer + " говорит: " + message);
                    }
                }
            }
        } else if (language.equals("EN")) {
            if (message.toCharArray()[0] == '!' && message.length() != 1) {
                message = message.substring(1);
                for (Player i : playersAll) {
                    if (player.getLocation().distance(i.getLocation()) <= 60d) {
                        i.sendMessage(namePlayer + screamColor + " screams: " + ChatColor.RESET + message);
                        System.out.println(namePlayer + " screams: " + message);

                    }
                }
            } else if (message.toCharArray()[0] == ',' && message.length() != 1) {
                message = message.substring(1);
                for (Player i : playersAll) {
                    if (player.getLocation().distance(i.getLocation()) <= 3d) {
                        i.sendMessage(namePlayer + whisperColor + " whispers: " + ChatColor.RESET + message);
                        System.out.println(namePlayer + " whispers: " + message);
                    }
                }
            } else if (message.toCharArray()[0] == '_' && message.length() != 1) {
                message = message.substring(1);
                for (Player i : playersAll) {
                    if (player.getLocation().distance(i.getLocation()) <= 20d) {
                        i.sendMessage(loocColor + namePlayer + ": ((" + message + "))");
                        System.out.println(namePlayer + ": (( " + message + "))");
                    }
                }
            } else {
                for (Player i : playersAll) {
                    if (player.getLocation().distance(i.getLocation()) <= 20d) {
                        i.sendMessage(namePlayer + defaultColor + " says: " + ChatColor.RESET + message);
                        System.out.println(namePlayer + " says: " + message);
                    }
                }
            }
        } else return true;

        e.setCancelled(true);
        return true;
    }
}