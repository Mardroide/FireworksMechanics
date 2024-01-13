package dev.mardroide.fireworksmechanics.listeners.dinamyte;

import dev.mardroide.fireworksmechanics.FireworksMechanics;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Entity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.persistence.PersistentDataType;

public class EntityDamageByEntityListener implements Listener {
    private final NamespacedKey key = new NamespacedKey(FireworksMechanics.getInstance(), "failure-dynamite");

    @EventHandler
    public void onDamage(EntityDamageByEntityEvent event) {
        Entity entity = event.getDamager();

        if (entity.getPersistentDataContainer().has(key, PersistentDataType.BYTE)) {
            event.setCancelled(true);
        }
    }
}
