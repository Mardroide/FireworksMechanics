package dev.mardroide.fireworksmechanics.listeners.fireworks;

import dev.mardroide.fireworksmechanics.config.MainConfiguration;
import dev.mardroide.fireworksmechanics.utils.GenerateRandomTrigger;
import org.bukkit.Bukkit;
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

public class InteractFireworksListener implements Listener {

    @EventHandler()
    public void onInteraction(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        ItemStack handItem = event.getItem();

        if (!itemEquippedInAnyHand(player)) return;
        double trigger = new GenerateRandomTrigger().getRandom();

        if (handItem.getItemMeta().getDisplayName().equals("Reinforced firework")) trigger *= 1.5;

        if (event.getAction() == Action.RIGHT_CLICK_BLOCK) {
            if (trigger > MainConfiguration.getExplodeFailRate("fireworks")) return;

            event.setCancelled(true);
            handlePlayerExplosion(player);
            handItem.setAmount(handItem.getAmount() - 1);
        }

        if (event.getAction() == Action.RIGHT_CLICK_AIR) {
            if (trigger > MainConfiguration.getBoostFailRate()) return;
            if (!player.isGliding()) return;

            event.setCancelled(true);
            handleFireworkElytraFailure(player);
            handItem.setAmount(handItem.getAmount() - 1);
        }
    }

    private boolean itemEquippedInAnyHand(@NotNull Player player) {
        boolean mainHandEquipped = player.getInventory().getItemInMainHand().getType() == Material.FIREWORK_ROCKET;
        boolean secondaryHandEquipped = player.getInventory().getItemInOffHand().getType() == Material.FIREWORK_ROCKET;
        return mainHandEquipped || secondaryHandEquipped;
    }

    private void handlePlayerExplosion(@NotNull Player player) {
        Location playerLocation = player.getLocation();
        player.getWorld().createExplosion(playerLocation.getX(), playerLocation.getY(), playerLocation.getZ(), 1f, true, false);
    }

    public static void handleFireworkElytraFailure(@NotNull Player player) {
        Location playerLocation = player.getLocation();
        player.playSound(playerLocation, Sound.ENTITY_GENERIC_EXTINGUISH_FIRE, 10, 10);
    }
}
