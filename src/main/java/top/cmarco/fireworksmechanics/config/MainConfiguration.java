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
        String str = config.getString("fireworks.explode-fail-rate");
        Double value = null;
        try {
            value = Double.parseDouble(str.substring(0, str.length() - 1));
        } catch (NullPointerException | NumberFormatException e) {
            plugin.getLogger().warning("Invalid config.yml format for explode-fail-rate!");
        }
        if (value == null) value = 1.d;
        return value;
    }
}
