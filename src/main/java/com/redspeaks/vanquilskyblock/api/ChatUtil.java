package com.redspeaks.vanquilskyblock.api;

import org.bukkit.ChatColor;

public class ChatUtil {


    public static String colorize(String text) {
        return ChatColor.translateAlternateColorCodes('&', text);
    }

    public static String strip(String text) {
        return ChatColor.stripColor(text);
    }
}
