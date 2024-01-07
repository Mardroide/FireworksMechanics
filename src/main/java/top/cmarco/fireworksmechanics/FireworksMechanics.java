package top.cmarco.fireworksmechanics;

import lombok.Getter;
import org.bukkit.plugin.java.JavaPlugin;
import top.cmarco.fireworksmechanics.config.MainConfiguration;
import top.cmarco.fireworksmechanics.listeners.PlayerDeathListener;
import top.cmarco.fireworksmechanics.listeners.fireworks.InteractFireworksListener;
import top.cmarco.fireworksmechanics.utils.ColorFormatter;

@Getter
public final class FireworksMechanics extends JavaPlugin {

    private MainConfiguration mainConfiguration;

    /**
     * Load the config and read its values from config.yml
     */
    private void startConfig() {
        mainConfiguration = new MainConfiguration(this);
        mainConfiguration.loadValues();
    }

    @Override
    public void onEnable() {
        startConfig();

        getServer().getPluginManager().registerEvents(new InteractFireworksListener(), this);
        getServer().getPluginManager().registerEvents(new PlayerDeathListener(), this);
        ColorFormatter.sendConsoleMessage("&2[FireworksMechanics] &aenabled!");
    }

    @Override
    public void onDisable() {
        ColorFormatter.sendConsoleMessage("&2[FireworksMechanics] &cdisabled!");
    }
}
