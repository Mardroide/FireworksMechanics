package dev.mardroide.fireworksmechanics.listeners.dinamyte;

import dev.mardroide.fireworksmechanics.config.MainConfiguration;
import dev.mardroide.fireworksmechanics.utils.EventActivation;
import dev.mardroide.fireworksmechanics.utils.GenerateRandomTrigger;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.TNTPrimed;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.inventory.ItemStack;

public class DynamiteExplodeListener implements Listener {
    private EventActivation eventAction = new EventActivation();

    @EventHandler
    public void onBlockExplode(EntityExplodeEvent event) {
        if (!event.getEntity().getType().equals(EntityType.PRIMED_TNT)) return;

        TNTPrimed dynamite = (TNTPrimed) event.getEntity();
        Entity source = dynamite.getSource();

        if (MainConfiguration.getReduceFireTicksOption()) {
            int ticks = MainConfiguration.getFireTicksSeconds() * 20;
            dynamite.setFuseTicks(ticks);
        }

        if (source.getType().equals(EntityType.PLAYER) && source.isValid()) {
            double random = new GenerateRandomTrigger().getRandom();

            if (random > MainConfiguration.getExplodeFailRate("dynamite")) return;
            event.setCancelled(true);
            eventAction.setActivated(true);

            if (!MainConfiguration.getDropItemOption()) return;
            Location blockLocation = event.getLocation();
            event.getLocation().getWorld().dropItem(blockLocation, new ItemStack(Material.TNT, 1));
        }
    }
}
