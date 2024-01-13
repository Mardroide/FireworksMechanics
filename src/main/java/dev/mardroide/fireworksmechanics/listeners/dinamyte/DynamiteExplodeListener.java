package dev.mardroide.fireworksmechanics.listeners.dinamyte;

import dev.mardroide.fireworksmechanics.FireworksMechanics;
import dev.mardroide.fireworksmechanics.config.MainConfiguration;
import dev.mardroide.fireworksmechanics.utils.GenerateRandomTrigger;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.TNTPrimed;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataType;

public class DynamiteExplodeListener implements Listener {
    private final NamespacedKey key = new NamespacedKey(FireworksMechanics.getInstance(), "failure-dynamite");

    @EventHandler()
    public void onBlockExplode(EntityExplodeEvent event) {
        if (event.getEntity().getType() != EntityType.PRIMED_TNT) return;

        Entity entity = event.getEntity();
        TNTPrimed dynamite = (TNTPrimed) event.getEntity();
        Entity source = dynamite.getSource();


        if (MainConfiguration.getReduceFireTicksOption()) {
            int ticks = MainConfiguration.getFireTicksSeconds() * 20;
            dynamite.setFuseTicks(ticks);
        }

        if (source.getType() == EntityType.PLAYER && source.isValid()) {
            double random = new GenerateRandomTrigger().getRandom();

            if (random > MainConfiguration.getExplodeFailRate("dynamite")) return;
            entity.getPersistentDataContainer().set(key, PersistentDataType.BYTE, (byte) 1);
            event.setCancelled(true);

            if (!MainConfiguration.getDropItemOption()) return;
            Location blockLocation = event.getLocation();
            event.getLocation().getWorld().dropItem(blockLocation, new ItemStack(Material.TNT, 1));
        }
    }
}
