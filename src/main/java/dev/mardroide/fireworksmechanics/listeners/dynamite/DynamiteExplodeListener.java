package dev.mardroide.fireworksmechanics.listeners.dynamite;

import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityExplodeEvent;

public class DynamiteExplodeListener implements Listener {
    @EventHandler(priority = EventPriority.NORMAL)
    public void onDynamiteExplode(EntityExplodeEvent event) {
        EntityType entityType = event.getEntity().getType();
        if (!entityType.equals(EntityType.PRIMED_TNT)) return;

        //event.setCancelled(true);
    }
}
