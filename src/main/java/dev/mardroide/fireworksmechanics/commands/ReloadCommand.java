package dev.mardroide.fireworksmechanics.commands;

import dev.mardroide.fireworksmechanics.FireworksMechanics;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ReloadCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (player.hasPermission("fireworksmechanics.reload") || player.isOp()) {
                FireworksMechanics.getInstance().reloadConfig();
                player.sendMessage(ChatColor.GREEN + "FireworksMechanics reloaded!");
                return true;
            }
        } else {
            FireworksMechanics.getInstance().reloadConfig();
            Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN + "FireworksMechanics reloaded!");
        }

        return false;
    }
}
