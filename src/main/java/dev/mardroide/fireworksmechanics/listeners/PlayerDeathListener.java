package dev.mardroide.fireworksmechanics.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class PlayerDeathListener implements Listener {
    @EventHandler
    public void onDeath(PlayerDeathEvent event) {
        Player player = event.getEntity().getPlayer();
        if (player.getKiller() != null) return;

        event.setDeathMessage("The artifact of " + player.getName() + " has exploded sooner than expected.");
    }
}
