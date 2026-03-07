package net.hederamc.fishbonetrehalose.api;

import net.minecraft.world.scores.PlayerTeam;
import org.jspecify.annotations.Nullable;

public interface TeamMember {
    @Nullable
    default PlayerTeam getTeam() {
        throw new UnsupportedOperationException();
    }

    default PlayerTeam getOrAddToTeam(String name) {
        throw new UnsupportedOperationException();
    }
}
