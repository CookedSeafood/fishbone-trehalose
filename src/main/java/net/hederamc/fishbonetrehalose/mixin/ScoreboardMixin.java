package net.hederamc.fishbonetrehalose.mixin;

import it.unimi.dsi.fastutil.objects.Object2ObjectMap;
import it.unimi.dsi.fastutil.objects.Reference2ObjectMap;
import java.util.List;
import java.util.Map;
import net.hederamc.fishbonetrehalose.api.ObjectiveHolder;
import net.hederamc.fishbonetrehalose.api.PlayerTeamHolder;
import net.minecraft.world.scores.DisplaySlot;
import net.minecraft.world.scores.Objective;
import net.minecraft.world.scores.PlayerScores;
import net.minecraft.world.scores.PlayerTeam;
import net.minecraft.world.scores.Scoreboard;
import net.minecraft.world.scores.criteria.ObjectiveCriteria;
import org.jspecify.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(Scoreboard.class)
public abstract class ScoreboardMixin implements ObjectiveHolder, PlayerTeamHolder {
    @Shadow private Object2ObjectMap<String, Objective> objectivesByName;
    @Shadow private Reference2ObjectMap<ObjectiveCriteria, List<Objective>> objectivesByCriteria;
    @Shadow private Map<String, PlayerScores> playerScores;
    @Shadow private Object2ObjectMap<String, PlayerTeam> teamsByName;
    @Shadow private Object2ObjectMap<String, PlayerTeam> teamsByPlayer;

    @Override
    public boolean containsObjective(String name) {
        return this.objectivesByName.containsKey(name);
    }

    @Nullable
    @Override
    public Objective removeObjective(String name) {
        Objective objective = this.objectivesByName.remove(name);

        if (objective == null) {
            return null;
        }

        for (DisplaySlot value : DisplaySlot.values()) {
            if (this.getDisplayObjective(value) == objective) {
                this.setDisplayObjective(value, null);
            }
        }

        List<Objective> objectives = this.getObjectives(objective.getCriteria());

        if (objectives != null) {
            objectives.remove(objective);
        }

        for (PlayerScores playerScore : this.playerScores.values()) {
            playerScore.remove(objective);
        }

        this.onObjectiveRemoved(objective);
        return objective;
    }

    @Override
    public List<Objective> getObjectives(ObjectiveCriteria criteria) {
        return this.objectivesByCriteria.get(criteria);
    }

    @Override
    public boolean containsPlayerTeam(String name) {
        return this.teamsByName.containsKey(name);
    }

    @Nullable
    @Override
    public PlayerTeam removePlayerTeam(String name) {
        PlayerTeam team = this.teamsByName.remove(name);

        if (team == null) {
            return null;
        }

        for (String player : team.getPlayers()) {
            this.removePlayerFromTeam(player, team);
        }

        this.onTeamRemoved(team);
        return team;
    }

    @Nullable
    @Shadow
    public abstract Objective getDisplayObjective(DisplaySlot slot);

    @Shadow
    public abstract void setDisplayObjective(DisplaySlot slot, @Nullable Objective objective);

    @Shadow
    public abstract void removePlayerFromTeam(String player, PlayerTeam team);

    @Shadow
    public abstract void onObjectiveRemoved(Objective objective);

    @Shadow
    public abstract void onTeamRemoved(PlayerTeam team);
}
