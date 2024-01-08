package dev.mardroide.fireworksmechanics.handlers;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.meta.FireworkMeta;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;

public class HandleFireworkMechanics {
    public static void handlePlayerExplosion(@NotNull Player player) {
        Location playerLocation = player.getLocation();
        player.getWorld().createExplosion(playerLocation, 2f, true, false);
    }

    public static void handlePlayerElytra(@NotNull Player player, ItemMeta itemMeta) {
        if (player.getInventory().getChestplate().getType().equals(Material.ELYTRA) && player.isGliding()) {
            FireworkMeta meta = (FireworkMeta) itemMeta;
            Bukkit.getConsoleSender().sendMessage(String.valueOf(meta.getPower()));
        }
    }
}
