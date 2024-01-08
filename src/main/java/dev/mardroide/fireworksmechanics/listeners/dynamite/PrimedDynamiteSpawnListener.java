package dev.mardroide.fireworksmechanics.listeners.dynamite;

import dev.mardroide.fireworksmechanics.config.MainConfiguration;
import dev.mardroide.fireworksmechanics.utils.RandomExplosionTrigger;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.TNTPrimed;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntitySpawnEvent;

public class PrimedDynamiteSpawnListener implements Listener {
    private MainConfiguration config;

    @EventHandler(priority = EventPriority.NORMAL)
    public void onPrimedDinamyteSpawn(EntitySpawnEvent event) {
        EntityType type = event.getEntityType();
        if (!type.equals(EntityType.PRIMED_TNT)) return;
        if (RandomExplosionTrigger.earlyExplodeTrigger()) return;

        TNTPrimed dynamite = (TNTPrimed) event.getEntity();
        dynamite.setFuseTicks(MainConfiguration.getEarlyExplodePreset());
    }
}
