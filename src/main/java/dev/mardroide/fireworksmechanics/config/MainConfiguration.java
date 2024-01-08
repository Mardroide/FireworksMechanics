package dev.mardroide.fireworksmechanics.config;

import dev.mardroide.fireworksmechanics.FireworksMechanics;
import org.bukkit.configuration.file.FileConfiguration;

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

    public static double getBoostFailRate() {
        return config.getDouble("fireworks.boost-fail-rate");
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
