package dev.mardroide.fireworksmechanics.listeners.fireworks;

import dev.mardroide.fireworksmechanics.config.MainConfiguration;
import dev.mardroide.fireworksmechanics.utils.GenerateRandomTrigger;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.ThreadLocalRandom;

public class InteractFireworksListener implements Listener {
    @EventHandler()
    public void onInteraction(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        ItemStack handItem = event.getItem();

        if (!itemEquippedInAnyHand(player)) return;

        if (event.getAction() == Action.RIGHT_CLICK_BLOCK) {
            if (GenerateRandomTrigger.randomTrigger() >= MainConfiguration.getExplodeFailRate()) return;

            event.setCancelled(true);
            handlePlayerExplosion(player);
            handItem.setAmount(handItem.getAmount() - 1);
        }

        if (event.getAction() == Action.RIGHT_CLICK_AIR) {
            if (GenerateRandomTrigger.randomTrigger() >= MainConfiguration.getBoostFailRate()) return;
            if (!player.isGliding()) return;

            event.setCancelled(true);
            handleFireworkElytraFailure(player);
            handItem.setAmount(handItem.getAmount() - 1);
        }
    }

    private boolean itemEquippedInAnyHand(@NotNull Player player) {
        boolean mainHandEquipped = player.getInventory().getItemInMainHand().getType().equals(Material.FIREWORK_ROCKET);
        boolean secondaryHandEquipped = player.getInventory().getItemInOffHand().getType().equals(Material.FIREWORK_ROCKET);
        return mainHandEquipped || secondaryHandEquipped;
    }

    private void handlePlayerExplosion(@NotNull Player player) {
        Location playerLocation = player.getLocation();
        player.getWorld().createExplosion(playerLocation, 2f, true, false);
    }

    public static void handleFireworkElytraFailure(@NotNull Player player) {
        Location playerLocation = player.getLocation();
        player.playSound(playerLocation, Sound.ENTITY_GENERIC_EXTINGUISH_FIRE, 10, 10);
    }
}
