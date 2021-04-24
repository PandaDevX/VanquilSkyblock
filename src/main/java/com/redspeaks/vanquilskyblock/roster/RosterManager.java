package com.redspeaks.vanquilskyblock.roster;

import com.bgsoftware.superiorskyblock.api.wrappers.SuperiorPlayer;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class RosterManager {

    public static Roster getRoster(SuperiorPlayer player) {
        if(Rosters.rosters.isEmpty()) return null;
        for(Roster roster : Rosters.rosters) {
            if(roster.getLeader().equals(player.getUniqueId().toString())) {
                return roster;
            }
            if(roster.getMembers().contains(player.getUniqueId().toString())) {
                return roster;
            }
        }
        return null;
    }

    public static void createRoster(SuperiorPlayer player, int maxSize) {
         Rosters.rosters.add(new Roster() {
             final List<String> list = new ArrayList<>();
             @Override
             public String getLeader() {
                 return player.getUniqueId().toString();
             }

             @Override
             public List<String> getMembers() {
                 return list;
             }

             @Override
             public void addMember(Player toAdd) {
                 getMembers().add(toAdd.getUniqueId().toString());
             }

             @Override
             public void kickMember(Player member) {
                 getMembers().remove(member.getUniqueId().toString());
             }

             @Override
             public int getMaxSize() {
                 return maxSize;
             }
         });
    }

    public void disband(Roster roster) {
        Rosters.rosters.remove(roster);
    }
}
