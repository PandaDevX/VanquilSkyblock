package com.redspeaks.vanquilskyblock.roster;

import org.bukkit.entity.Player;

import java.util.List;

public interface Roster {

    String getLeader();
    List<String> getMembers();
    void addMember(Player toAdd);
    void kickMember(Player member);
    int getMaxSize();
}
