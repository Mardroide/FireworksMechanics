package top.cmarco.fireworksmechanics;

import lombok.Getter;
import org.bukkit.plugin.java.JavaPlugin;
import top.cmarco.fireworksmechanics.config.MainConfiguration;
import top.cmarco.fireworksmechanics.listeners.PlayerDeathListener;
import top.cmarco.fireworksmechanics.listeners.fireworks.InteractFireworksListener;
import top.cmarco.fireworksmechanics.utils.ColorFormatter;
import top.cmarco.fireworksmechanics.utils.UpdateChecker;

@Getter
public final class FireworksMechanics extends JavaPlugin {

    private MainConfiguration mainConfiguration;
    private final int resourceId = 12345;

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

        new UpdateChecker(this, resourceId).getVersion(version -> {
            if (!this.getDescription().getVersion().equals(version)) {
                ColorFormatter.sendConsoleMessage("&2[FireworksMechanics] &eNew version available!");
            }
        });
    }

    @Override
    public void onDisable() {
        ColorFormatter.sendConsoleMessage("&2[FireworksMechanics] &cdisabled!");
    }
}
