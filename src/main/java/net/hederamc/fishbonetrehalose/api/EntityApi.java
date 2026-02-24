package net.hederamc.fishbonetrehalose.api;

import net.minecraft.world.scores.PlayerTeam;

public interface EntityApi {
    default PlayerTeam getOrAddToTeam(String name) {
        throw new UnsupportedOperationException();
    }
}
