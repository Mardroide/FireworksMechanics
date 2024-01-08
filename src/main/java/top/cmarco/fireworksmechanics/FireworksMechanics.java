package top.cmarco.fireworksmechanics;

import lombok.Getter;
import org.bukkit.plugin.java.JavaPlugin;
import top.cmarco.fireworksmechanics.config.MainConfiguration;
import top.cmarco.fireworksmechanics.listeners.PlayerDeathListener;
import top.cmarco.fireworksmechanics.listeners.dynamite.DynamiteExplodeListener;
import top.cmarco.fireworksmechanics.listeners.dynamite.PrimedDynamiteSpawnListener;
import top.cmarco.fireworksmechanics.listeners.fireworks.InteractFireworksListener;
import top.cmarco.fireworksmechanics.utils.ColorFormatter;
import top.cmarco.fireworksmechanics.utils.UpdateChecker;

@Getter
public final class FireworksMechanics extends JavaPlugin {

    private MainConfiguration mainConfiguration;
    private final int resourceId = 12345;

    private void startConfig() {
        mainConfiguration = new MainConfiguration(this);
        mainConfiguration.loadValues();
    }

    @Override
    public void onEnable() {
        startConfig();

        getServer().getPluginManager().registerEvents(new InteractFireworksListener(), this);
        getServer().getPluginManager().registerEvents(new PlayerDeathListener(), this);
        getServer().getPluginManager().registerEvents(new PrimedDynamiteSpawnListener(), this);
        getServer().getPluginManager().registerEvents(new DynamiteExplodeListener(), this);
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
