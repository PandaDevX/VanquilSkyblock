package com.redspeaks.vanquilskyblock.gui;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class InventorySettings {
    private final String name;
    private final int size;

}
