package dev.mardroide.fireworksmechanics.commands;

import dev.mardroide.fireworksmechanics.FireworksMechanics;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class MainCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player player) {
            if (args[0].equals("reload") && (player.hasPermission("fireworksmechanics.reload") || player.isOp())) {
                FireworksMechanics.getInstance().saveDefaultConfig();
                player.sendMessage(ChatColor.GREEN + "FireworksMechanics reloaded!");
                return true;
            }
        } else {
            if (args[0].equals("reload")) {
                FireworksMechanics.getInstance().saveDefaultConfig();
                Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN + "FireworksMechanics reloaded!");
                return true;
            }
        }

        return false;
    }
}
