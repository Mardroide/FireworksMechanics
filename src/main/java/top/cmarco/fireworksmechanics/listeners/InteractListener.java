package top.cmarco.fireworksmechanics.listeners;

import lombok.RequiredArgsConstructor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
import top.cmarco.fireworksmechanics.FireworksMechanics;

import java.util.concurrent.ThreadLocalRandom;

@RequiredArgsConstructor
public final class InteractListener implements Listener {

    private final ThreadLocalRandom random = ThreadLocalRandom.current();
    private final FireworksMechanics plugin;

    /**
     * Method called when the player fires a rocket.
     * @param player The player.
     */
    private void handleFireworkMechanics(@NotNull Player player) {
        if (random.nextDouble(0.00, 100.00) >= plugin.getMainConfiguration().getExplodeFailRate()) {
            return;
        }

        // behaviour code below:
    }

    @EventHandler(priority = EventPriority.NORMAL)
    public void onEvent(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        if (event.getAction() != Action.RIGHT_CLICK_BLOCK) return;
        ItemStack handStack = player.getItemInUse();
        if (handStack == null) return;
        Material handMaterial = handStack.getType();
        if (handMaterial != Material.FIREWORK_ROCKET) return;

        handleFireworkMechanics(player);
    }
}
