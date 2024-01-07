package top.cmarco.fireworksmechanics.utils;

import org.bukkit.Bukkit;

public class ColorFormatter {
    public static String colourString(String message) {
        return message.replace("&", "§");
    }

    public static void sendConsoleMessage(String message) {
        Bukkit.getConsoleSender().sendMessage(colourString(message));
    }
}
