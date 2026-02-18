package net.hederamc.fishbonetrehalose.api;

import net.minecraft.world.scores.PlayerTeam;
import org.jspecify.annotations.Nullable;

public interface PlayerTeamHolder {
    default boolean containsPlayerTeam(String name) {
        throw new UnsupportedOperationException();
    }

    @Nullable
    default PlayerTeam getPlayerTeam(String name) {
        throw new UnsupportedOperationException();
    }

    default PlayerTeam addPlayerTeam(String name) {
        throw new UnsupportedOperationException();
    }

    default PlayerTeam getOrAddPlayerTeam(String name) {
        PlayerTeam team = this.getPlayerTeam(name);

        if (team == null) {
            team = this.addPlayerTeam(name);
        }

        return team;
    }

    @Nullable
    default PlayerTeam removePlayerTeam(String name) {
        throw new UnsupportedOperationException();
    }

    default void removePlayerTeam(PlayerTeam team) {
        throw new UnsupportedOperationException();
    }
}
