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

    public double getEarlyExplodeRate() {
        return config.getDouble("early-explode-rate");
    }

    public int getEarlyExplodePreset() {
        int preset = config.getInt("early-explode-preset");

        return switch (preset) {
            case 1 -> 20;
            case 2 -> 30;
            case 3 -> 40;
            default -> 0;
        };
    }
}
