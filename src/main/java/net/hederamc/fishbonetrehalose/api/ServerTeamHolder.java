package net.hederamc.fishbonetrehalose.api;

import net.minecraft.world.scores.PlayerTeam;
import org.jspecify.annotations.Nullable;

public interface ServerTeamHolder {
    default boolean containsTeam(String name) {
        throw new UnsupportedOperationException();
    }

    @Nullable
    default PlayerTeam getTeam(String name) {
        throw new UnsupportedOperationException();
    }

    default boolean addTeam(String name) {
        throw new UnsupportedOperationException();
    }

    default boolean addTeam(PlayerTeam team) {
        throw new UnsupportedOperationException();
    }

    @Nullable
    default PlayerTeam removeTeam(String name) {
        throw new UnsupportedOperationException();
    }

    default void removeTeam(PlayerTeam team) {
        throw new UnsupportedOperationException();
    }

    default PlayerTeam getOrAddTeam(String name) {
        throw new UnsupportedOperationException();
    }
}
