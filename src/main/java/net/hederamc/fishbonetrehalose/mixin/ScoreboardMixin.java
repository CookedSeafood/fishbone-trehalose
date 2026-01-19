package net.hederamc.fishbonetrehalose.mixin;

import it.unimi.dsi.fastutil.objects.Object2ObjectMap;
import net.hederamc.fishbonetrehalose.api.ScoreboardApi;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.numbers.NumberFormat;
import net.minecraft.world.scores.Objective;
import net.minecraft.world.scores.PlayerTeam;
import net.minecraft.world.scores.Scoreboard;
import net.minecraft.world.scores.criteria.ObjectiveCriteria;
import net.minecraft.world.scores.criteria.ObjectiveCriteria.RenderType;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(Scoreboard.class)
public abstract class ScoreboardMixin implements ScoreboardApi {
    @Shadow private Object2ObjectMap<String, Objective> objectivesByName;
    @Shadow private Object2ObjectMap<String, PlayerTeam> teamsByName;

    @Override
    public boolean containsObjective(String name) {
        return this.objectivesByName.containsKey(name);
    }

    @Override
    public Objective getOrAddObjective(String name, ObjectiveCriteria criterion, Component displayName,
            RenderType renderType, boolean displayAutoUpdate, @Nullable NumberFormat numberFormat) {
        Objective objective = this.getObjective(name);
        if (objective == null) {
            objective = this.addObjective(name, criterion, displayName, renderType, displayAutoUpdate, numberFormat);
        }

        return objective;
    }

    @Override
    public boolean containsPlayerTeam(String name) {
        return this.teamsByName.containsKey(name);
    }

    @Override
    public PlayerTeam getOrAddPlayerTeam(String name) {
        PlayerTeam team = this.getPlayerTeam(name);
        if (team == null) {
            team = this.addPlayerTeam(name);
        }

        return team;
    }

    @Nullable
    @Shadow
    public abstract Objective getObjective(@Nullable String name);

    @Shadow
    public abstract Objective addObjective(String name, ObjectiveCriteria criteria, Component displayName,
            RenderType renderType, boolean displayAutoUpdate, @Nullable NumberFormat numberFormat);

    @Nullable
    @Shadow
    public abstract PlayerTeam getPlayerTeam(String name);

    @Shadow
    public abstract PlayerTeam addPlayerTeam(String name);
}
