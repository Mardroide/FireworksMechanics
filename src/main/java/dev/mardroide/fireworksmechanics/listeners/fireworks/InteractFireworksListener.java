package dev.mardroide.fireworksmechanics.listeners.fireworks;

import dev.mardroide.fireworksmechanics.utils.RandomExplosionTrigger;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;
import dev.mardroide.fireworksmechanics.handlers.HandleFireworkMechanics;

public class InteractFireworksListener implements Listener {
    @EventHandler(priority = EventPriority.NORMAL)
    public void onInteraction(PlayerInteractEvent event) {
        Player player = event.getPlayer();

        if (!itemEquippedInAnyHand(player)) return;

        if (event.getAction() == Action.RIGHT_CLICK_BLOCK) {
            if (RandomExplosionTrigger.failureTrigger()) return;
            event.setCancelled(true);
            HandleFireworkMechanics.handlePlayerExplosion(player);
        }

        if (event.getAction() == Action.RIGHT_CLICK_AIR) {
            if (RandomExplosionTrigger.boostFailureTrigger()) return;
            ItemMeta fireworkMeta = event.getItem().getItemMeta();
            HandleFireworkMechanics.handlePlayerElytra(player, fireworkMeta);
        }
    }

    private boolean itemEquippedInAnyHand(@NotNull Player player) {
        boolean mainHandEquipped = player.getInventory().getItemInMainHand().getType().equals(Material.FIREWORK_ROCKET);
        boolean secondaryHandEquipped = player.getInventory().getItemInOffHand().getType().equals(Material.FIREWORK_ROCKET);
        return mainHandEquipped || secondaryHandEquipped;
    }
}
