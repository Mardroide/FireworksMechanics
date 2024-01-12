package dev.mardroide.fireworksmechanics.utils;

import org.bukkit.Bukkit;

public class EventActivation {
    private static boolean isActivated;

    public void setActivated(boolean activated) {
        isActivated = activated;
    }

    public boolean isEventActivated() {
        return isActivated;
    }
}
