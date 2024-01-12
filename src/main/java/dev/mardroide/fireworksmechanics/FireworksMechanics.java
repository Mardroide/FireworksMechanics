package dev.mardroide.fireworksmechanics;

import dev.mardroide.fireworksmechanics.commands.MainCommand;
import dev.mardroide.fireworksmechanics.listeners.EntityDamageListener;
import dev.mardroide.fireworksmechanics.listeners.PlayerDeathListener;
import dev.mardroide.fireworksmechanics.listeners.dinamyte.DynamiteExplodeListener;
import dev.mardroide.fireworksmechanics.listeners.fireworks.InteractFireworksListener;
import dev.mardroide.fireworksmechanics.recipes.ReinforcedDynamite;
import dev.mardroide.fireworksmechanics.recipes.ReinforcedFirework;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;
import dev.mardroide.fireworksmechanics.config.MainConfiguration;
import dev.mardroide.fireworksmechanics.utils.UpdateChecker;

public final class FireworksMechanics extends JavaPlugin {
    private final String PREFIX = ChatColor.DARK_GREEN + "[FireworksMechanics]";
    private static FireworksMechanics Instance;

    @Override
    public void onEnable() {
        Instance = this;

        startConfig();
        registerRecipes();

        this.getCommand("fm").setExecutor(new MainCommand());

        getServer().getPluginManager().registerEvents(new InteractFireworksListener(), this);
        getServer().getPluginManager().registerEvents(new PlayerDeathListener(), this);
        getServer().getPluginManager().registerEvents(new DynamiteExplodeListener(), this);
        getServer().getPluginManager().registerEvents(new EntityDamageListener(), this);

        Bukkit.getConsoleSender().sendMessage(PREFIX + ChatColor.GREEN + " ready to work!");

        int resourceId = 12345;
        new UpdateChecker(resourceId).getVersion(version -> {
            if (!this.getDescription().getVersion().equals(version)) {
                Bukkit.getConsoleSender().sendMessage(PREFIX + ChatColor.YELLOW + " new update available!");
            }
        });
    }

    @Override
    public void onDisable() {
        Bukkit.getConsoleSender().sendMessage(PREFIX + ChatColor.RED + " disabled!");
    }

    public static FireworksMechanics getInstance() {
        return Instance;
    }

    private void startConfig() {
        MainConfiguration mainConfiguration = new MainConfiguration(this);
        mainConfiguration.loadValues();
    }

    private void registerRecipes() {
        new ReinforcedFirework();
        new ReinforcedDynamite();
    }
}
