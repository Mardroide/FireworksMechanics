package top.cmarco.fireworksmechanics;

import lombok.Getter;
import org.bukkit.plugin.java.JavaPlugin;
import top.cmarco.fireworksmechanics.config.MainConfiguration;
import top.cmarco.fireworksmechanics.listeners.InteractListener;

@Getter
public final class FireworksMechanics extends JavaPlugin {

    private MainConfiguration mainConfiguration;
    private InteractListener interactListener;

    /**
     * Load the config and read its values from config.yml
     */
    private void startConfig() {
        mainConfiguration = new MainConfiguration(this);
        mainConfiguration.loadValues();
    }

    /**
     * Start all listeners of this plugin.
     */
    private void startListeners() {
        getServer().getPluginManager().registerEvents(interactListener = new InteractListener(this),this);
    }

    /**
     * Startup method for this plugin.
     */
    @Override
    public void onEnable() {
        startConfig();
        startListeners();
    }
}
