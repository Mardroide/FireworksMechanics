package top.cmarco.fireworksmechanics.config;

import lombok.RequiredArgsConstructor;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import top.cmarco.fireworksmechanics.FireworksMechanics;

@RequiredArgsConstructor
public final class MainConfiguration {
    private FireworksMechanics plugin;
    private static FileConfiguration config = null;

    public MainConfiguration(FireworksMechanics plugin) {
        this.plugin = plugin;
    }

    public void loadValues() {
        if (config == null) {
            plugin.saveDefaultConfig();
            this.config = plugin.getConfig();
        }
    }

    public static double getExplodeFailRate() {
        return config.getDouble("fireworks.explode-fail-rate");
    }

    public static double getEarlyExplodeRate() {
        return config.getDouble("dynamite.early-explode-rate");
    }

    public static int getEarlyExplodePreset() {
        int preset = config.getInt("dynamite.early-explode-preset");

        return switch (preset) {
            case 1 -> 20;
            case 2 -> 30;
            case 3 -> 40;
            default -> 0;
        };
    }
}
