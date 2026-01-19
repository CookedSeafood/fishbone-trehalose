package net.hederamc.fishbonetrehalose.api;

import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.numbers.NumberFormat;
import net.minecraft.world.scores.Objective;
import net.minecraft.world.scores.PlayerTeam;
import net.minecraft.world.scores.criteria.ObjectiveCriteria;
import net.minecraft.world.scores.criteria.ObjectiveCriteria.RenderType;
import org.jetbrains.annotations.Nullable;

public interface ScoreboardApi {
    default boolean containsObjective(String name) {
        return false;
    }

    default Objective getOrAddObjective(String name, ObjectiveCriteria criterion, Component displayName, RenderType renderType, boolean displayAutoUpdate, @Nullable NumberFormat numberFormat) {
        return null;
    }

    default boolean containsPlayerTeam(String name) {
        return false;
    }

    default PlayerTeam getOrAddPlayerTeam(String name) {
        return null;
    }
}
