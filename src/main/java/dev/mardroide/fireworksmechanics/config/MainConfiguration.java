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
            config = plugin.getConfig();
        }
    }

    public static double getExplodeFailRate(String path) {
        return config.getDouble(path + ".explode-fail-rate");
    }

    public static double getBoostFailRate() {
        return config.getDouble("fireworks.boost-fail-rate");
    }

    public static boolean getDropItemOption() {
        return config.getBoolean("dynamite.drop-dynamite");
    }

    public static boolean getReduceFireTicksOption() {
        return  config.getBoolean("dynamite.reduce-fire-ticks");
    }

    public static int getFireTicksSeconds() {
        return config.getInt("dynamite.fire-ticks-seconds");
    }
}
