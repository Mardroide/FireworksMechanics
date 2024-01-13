package dev.mardroide.fireworksmechanics.listeners.dinamyte;

import dev.mardroide.fireworksmechanics.FireworksMechanics;
import org.bukkit.NamespacedKey;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

public class EntityDamageByEntityListener implements Listener {
    private final NamespacedKey key = new NamespacedKey(FireworksMechanics.getInstance(), "failure-dynamite");

    @EventHandler
    public void onEntityDamage(EntityDamageByEntityEvent event) {
        PersistentDataContainer container = event.getDamager().getPersistentDataContainer();

        if (container.has(key, PersistentDataType.BYTE)) {
            event.setCancelled(true);
        }
    }
}
