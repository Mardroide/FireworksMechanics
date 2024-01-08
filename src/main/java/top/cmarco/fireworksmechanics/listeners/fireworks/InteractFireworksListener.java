package top.cmarco.fireworksmechanics.listeners.fireworks;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import top.cmarco.fireworksmechanics.handlers.HandleFireworkMechanics;
import top.cmarco.fireworksmechanics.utils.RandomExplosionTrigger;

public class InteractFireworksListener implements Listener {
    @EventHandler(priority = EventPriority.NORMAL)
    public void onInteraction(PlayerInteractEvent event) {
        Player player = event.getPlayer();

        if (event.getAction() != Action.RIGHT_CLICK_BLOCK) return;
        if (!player.getInventory().getItemInMainHand().getType().equals(Material.FIREWORK_ROCKET)) return;
        if (RandomExplosionTrigger.failureTrigger()) return;

        event.setCancelled(true);
        HandleFireworkMechanics.handlePlayerExplosion(player);
    }
}
