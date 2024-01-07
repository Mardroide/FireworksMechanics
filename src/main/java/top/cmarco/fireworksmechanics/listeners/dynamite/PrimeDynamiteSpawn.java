package top.cmarco.fireworksmechanics.listeners.dynamite;

import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntitySpawnEvent;

public class PrimeDynamiteSpawn implements Listener {
    @EventHandler(priority = EventPriority.NORMAL)
    public void onExplosionPrime(EntitySpawnEvent event) {
        if (!event.getEntityType().equals(EntityType.PRIMED_TNT)) {}
    }
}
