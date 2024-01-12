package dev.mardroide.fireworksmechanics.listeners;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class PlayerDeathListener implements Listener {
    @EventHandler
    public void onDeath(PlayerDeathEvent event) {
        Player player = event.getEntity().getPlayer();
        event.setDeathMessage(ChatColor.GOLD + "The artifact of " + ChatColor.YELLOW + player.getName() + ChatColor.GOLD + " has exploded sooner than expected.");
    }
}
