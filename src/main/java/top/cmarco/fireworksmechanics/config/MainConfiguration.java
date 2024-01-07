package top.cmarco.fireworksmechanics.config;

import lombok.RequiredArgsConstructor;
import org.bukkit.configuration.file.FileConfiguration;
import top.cmarco.fireworksmechanics.FireworksMechanics;

@RequiredArgsConstructor
public final class MainConfiguration {
    private final FireworksMechanics plugin;
    private FileConfiguration config = null;

    public void loadValues() {
        if (config == null) {
            plugin.saveDefaultConfig();
            this.config = plugin.getConfig();
        }
    }

    public double getExplodeFailRate() {
        return config.getDouble("explode-fail-rate");
    }
}
