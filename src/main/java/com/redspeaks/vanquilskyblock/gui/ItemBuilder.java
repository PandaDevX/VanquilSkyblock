package com.redspeaks.vanquilskyblock.gui;

import org.bukkit.ChatColor;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ItemBuilder {

    private final ItemStack itemStack;
    private final ItemMeta itemMeta;

    public ItemBuilder(ItemOptions itemOptions) {
        this.itemStack = new ItemStack(itemOptions.getType());
        this.itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', itemOptions.getDisplayName()));
        if(!itemOptions.getLore().isEmpty()) {
            for(int i =0; i < itemOptions.getLore().size(); i++) {
                itemOptions.getLore().set(i, ChatColor.translateAlternateColorCodes('&', itemOptions.getLore().get(i)));
            }
            itemMeta.setLore(itemOptions.getLore());
        }
        if(itemOptions.getEnchantments().length > 0) {
            for(Enchantment enchantment : itemOptions.getEnchantments()) {
                itemMeta.addEnchant(enchantment, 1, true);
            }
        }
        if(itemOptions.getItemFlags().length > 0) {
            itemMeta.addItemFlags(itemOptions.getItemFlags());
        }
        itemStack.setItemMeta(itemMeta);
    }

    public ItemStack build() {
        return itemStack;
    }
}
