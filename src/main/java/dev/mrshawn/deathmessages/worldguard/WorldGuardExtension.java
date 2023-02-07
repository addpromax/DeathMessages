package dev.mrshawn.deathmessages.worldguard;

import com.sk89q.worldguard.WorldGuard;
import com.sk89q.worldguard.protection.flags.StateFlag;
import com.sk89q.worldguard.protection.flags.registry.FlagConflictException;
import com.sk89q.worldguard.protection.flags.registry.FlagRegistry;
import org.bukkit.entity.Player;


public interface WorldGuardExtension {
    StateFlag BROADCAST_PLAYER = new StateFlag("broadcast-deathmessage-player", true);
    StateFlag BROADCAST_MOBS = new StateFlag("broadcast-deathmessage-mobs", true);
    StateFlag BROADCAST_NATURAL = new StateFlag("broadcast-deathmessage-natural", true);
    StateFlag BROADCAST_ENTITY = new StateFlag("broadcast-deathmessage-entity", true);

    StateFlag.State getRegionState(Player player, String str);

    boolean isInRegion(Player player, String str);

    default void registerFlags() {
        FlagRegistry registry = WorldGuard.getInstance().getFlagRegistry();
        try {
            registry.register(BROADCAST_PLAYER);
        } catch (FlagConflictException e) {
            e.printStackTrace();
        }
        try {
            registry.register(BROADCAST_MOBS);
        } catch (FlagConflictException e2) {
            e2.printStackTrace();
        }
        try {
            registry.register(BROADCAST_NATURAL);
        } catch (FlagConflictException e3) {
            e3.printStackTrace();
        }
        try {
            registry.register(BROADCAST_ENTITY);
        } catch (FlagConflictException e4) {
            e4.printStackTrace();
        }
    }
}
