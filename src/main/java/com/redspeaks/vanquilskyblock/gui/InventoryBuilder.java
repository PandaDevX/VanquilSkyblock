package com.redspeaks.vanquilskyblock.gui;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.inventory.Inventory;

public class InventoryBuilder {

    private Inventory inventory = null;

    public InventoryBuilder(InventorySettings inventorySettings) {
        inventory = Bukkit.createInventory(null, inventorySettings.getSize(), ChatColor.translateAlternateColorCodes('&', inventorySettings.getName()));
    }

    public Inventory build() {
        return inventory;
    }
}
