package com.redspeaks.vanquilskyblock.gui;

import lombok.Builder;
import lombok.Getter;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;

import java.util.List;

@Builder
@Getter
public class ItemOptions {
    private final Material type;
    private final String displayName;
    private final List<String> lore;
    private final Enchantment[] enchantments;
    private final ItemFlag[] itemFlags;
}
