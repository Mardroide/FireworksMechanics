package top.cmarco.fireworksmechanics.handlers;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class HandleFireworkMechanics {
    public void handlePlayerExplosion(@NotNull Player player) {
        Location playerLocation = player.getLocation();
        player.getWorld().createExplosion(playerLocation, 2f, true, false);
    }
}
