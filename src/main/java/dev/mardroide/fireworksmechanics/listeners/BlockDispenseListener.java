package dev.mardroide.fireworksmechanics.listeners;

import dev.mardroide.fireworksmechanics.config.MainConfiguration;
import dev.mardroide.fireworksmechanics.utils.GenerateRandomTrigger;
import jdk.tools.jmod.Main;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockDispenseEvent;
import org.bukkit.inventory.ItemStack;

public class BlockDispenseListener implements Listener {
    @EventHandler
    public void onDispense(BlockDispenseEvent event) {
        if (event.getBlock().getType() != Material.DISPENSER) return;

        double trigger = new GenerateRandomTrigger().getRandom();
        ItemStack item = event.getItem();
        Location blockLocation = event.getBlock().getLocation();

        if (item.getType() == Material.TNT && MainConfiguration.getDispenserFeature("dynamite")) {
            if (trigger > MainConfiguration.getExplodeFailRate("dispensers")) return;

            event.setCancelled(true);
            blockLocation.getWorld().createExplosion(blockLocation, 1f);
        }

        if (item.getType() == Material.FIREWORK_ROCKET && MainConfiguration.getDispenserFeature("fireworks")) {
            if (trigger > MainConfiguration.getExplodeFailRate("dispensers")) return;

            event.setCancelled(true);
            blockLocation.getWorld().createExplosion(blockLocation, 1f);
        }
    }
}
