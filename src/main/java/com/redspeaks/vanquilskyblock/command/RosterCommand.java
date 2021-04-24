package com.redspeaks.vanquilskyblock.command;

import com.bgsoftware.superiorskyblock.api.SuperiorSkyblock;
import com.bgsoftware.superiorskyblock.api.SuperiorSkyblockAPI;
import com.bgsoftware.superiorskyblock.api.commands.SuperiorCommand;
import com.bgsoftware.superiorskyblock.api.wrappers.SuperiorPlayer;
import com.redspeaks.vanquilskyblock.gui.InventoryBuilder;
import com.redspeaks.vanquilskyblock.gui.InventorySettings;
import com.redspeaks.vanquilskyblock.roster.Roster;
import com.redspeaks.vanquilskyblock.roster.RosterManager;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

public class RosterCommand implements SuperiorCommand {


    @Override
    public List<String> getAliases() {
        return Collections.singletonList("roster");
    }

    @Override
    public String getPermission() {
        return "vanquil.island.roster";
    }

    @Override
    public String getUsage(Locale locale) {
        return "roster";
    }

    @Override
    public String getDescription(Locale locale) {
        return "Island roster";
    }

    @Override
    public int getMinArgs() {
        return 1;
    }

    @Override
    public int getMaxArgs() {
        return 4;
    }

    @Override
    public boolean canBeExecutedByConsole() {
        return false;
    }

    @Override
    public boolean displayCommand() {
        return true;
    }

    @Override
    public void execute(SuperiorSkyblock plugin, CommandSender sender, String[] args) {
        SuperiorPlayer player = SuperiorSkyblockAPI.getPlayer((Player) sender);
        if(player.getIslandLeader().asPlayer().equals(player.asPlayer())) {
            RosterManager.createRoster(player, 15);
        }
        Roster roster = RosterManager.getRoster(player);
        if(roster == null) {
            player.asPlayer().sendMessage(ChatColor.translateAlternateColorCodes('&', "&a&lVanquil &8>> &7No roster found"));
            return;
        }
        if(args.length == 1) {
            Inventory inventory = new InventoryBuilder(InventorySettings.builder()
            .name("&7Island Rosters...")
            .size(5*9)
            .build()).build();
            player.asPlayer().openInventory(inventory);
        }
    }

    @Override
    public List<String> tabComplete(SuperiorSkyblock plugin, CommandSender sender, String[] args) {
        return new ArrayList<>();
    }
}
