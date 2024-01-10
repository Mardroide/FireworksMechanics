package dev.mardroide.fireworksmechanics.listeners.dinamyte;

import dev.mardroide.fireworksmechanics.config.MainConfiguration;
import dev.mardroide.fireworksmechanics.utils.GenerateRandomTrigger;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.TNTPrimeEvent;

public class TntPrimeListener implements Listener {
    @EventHandler
    public void onPrime(TNTPrimeEvent event) {
        if (!event.getCause().equals(TNTPrimeEvent.PrimeCause.PLAYER)) return;
        if (GenerateRandomTrigger.randomTrigger() >= MainConfiguration.getEarlyExplodeRate()) return;

        event.setCancelled(true);

        Block dynamite = event.getBlock();
        Location dynamoteLocation = dynamite.getLocation();

        dynamite.setType(Material.AIR);
        dynamite.getWorld().createExplosion(dynamoteLocation, 4f, false, true);
    }
}
