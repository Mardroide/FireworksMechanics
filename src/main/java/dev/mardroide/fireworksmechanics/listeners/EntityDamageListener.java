package dev.mardroide.fireworksmechanics.listeners;

import dev.mardroide.fireworksmechanics.utils.EventActivation;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

public class EntityDamageListener implements Listener {
    private EventActivation eventAction = new EventActivation();

    @EventHandler
    public void onEntityDamage(EntityDamageEvent event) {
        if (!eventAction.isEventActivated()) return;

        eventAction.setActivated(false);
        event.setDamage(0);
        event.setCancelled(true);
    }
}
