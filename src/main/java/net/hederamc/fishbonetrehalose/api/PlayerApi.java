package net.hederamc.fishbonetrehalose.api;

import net.minecraft.world.scores.ScoreHolder;

public interface PlayerApi {
    default ScoreHolder getScoreHolder() {
        return null;
    }
}
