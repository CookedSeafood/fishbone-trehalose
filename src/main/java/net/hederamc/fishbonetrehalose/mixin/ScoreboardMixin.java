package net.hederamc.fishbonetrehalose.mixin;

import com.google.common.collect.Lists;
import it.unimi.dsi.fastutil.objects.Object2ObjectMap;
import it.unimi.dsi.fastutil.objects.Reference2ObjectMap;
import java.util.List;
import java.util.Map;
import net.hederamc.fishbonetrehalose.api.ObjectiveHolder;
import net.hederamc.fishbonetrehalose.api.ServerTeamHolder;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.numbers.NumberFormat;
import net.minecraft.world.scores.DisplaySlot;
import net.minecraft.world.scores.Objective;
import net.minecraft.world.scores.PlayerScores;
import net.minecraft.world.scores.PlayerTeam;
import net.minecraft.world.scores.Scoreboard;
import net.minecraft.world.scores.criteria.ObjectiveCriteria;
import net.minecraft.world.scores.criteria.ObjectiveCriteria.RenderType;
import org.jspecify.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(Scoreboard.class)
public abstract class ScoreboardMixin implements ObjectiveHolder, ServerTeamHolder {
    @Shadow private Object2ObjectMap<String, Objective> objectivesByName;
    @Shadow private Reference2ObjectMap<ObjectiveCriteria, List<Objective>> objectivesByCriteria;
    @Shadow private Map<String, PlayerScores> playerScores;
    @Shadow private Object2ObjectMap<String, PlayerTeam> teamsByName;
    @Shadow private Object2ObjectMap<String, PlayerTeam> teamsByPlayer;

    @Override
    public boolean containsObjective(String name) {
        return this.objectivesByName.containsKey(name);
    }

    @Override
    public boolean addObjective(String name, ObjectiveCriteria criteria, Component displayName,
            RenderType renderType, boolean displayAutoUpdate, @Nullable NumberFormat numberFormat) {
        if (this.containsObjective(name)) {
            return false;
        }

        return this.addObjective(new Objective((Scoreboard)(Object)this, name, criteria, displayName,
                renderType, displayAutoUpdate, numberFormat));
    }

    @Override
    public boolean addObjective(Objective objective) {
        this.objectivesByCriteria.computeIfAbsent(objective.getCriteria(), k -> Lists.<Objective>newArrayList()).add(objective);
        this.objectivesByName.put(objective.getName(), objective);
        this.onObjectiveAdded(objective);
        return true;
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
    public Objective getOrAddObjective(String name, ObjectiveCriteria criteria, Component displayName,
            RenderType renderType, boolean displayAutoUpdate, @Nullable NumberFormat numberFormat) {
        Objective objective = this.getObjective(name);

        if (objective == null) {
            objective = new Objective((Scoreboard)(Object)this, name, criteria, displayName,
                    renderType, displayAutoUpdate, numberFormat);
            this.addObjective(objective);
        }

        return objective;
    }

    @Override
    public List<Objective> getObjectives(ObjectiveCriteria criteria) {
        return this.objectivesByCriteria.get(criteria);
    }

    @Override
    public boolean containsTeam(String name) {
        return this.teamsByName.containsKey(name);
    }

    @Nullable
    @Override
    public PlayerTeam getTeam(String name) {
        return this.teamsByName.get(name);
    }

    @Override
    public boolean addTeam(String name) {
        if (this.containsTeam(name)) {
            return false;
        }

        return this.addTeam(new PlayerTeam((Scoreboard)(Object)this, name));
    }

    @Override
    public boolean addTeam(PlayerTeam team) {
        this.teamsByName.put(team.getName(), team);
        this.onTeamAdded(team);
        return true;
    }

    @Nullable
    @Override
    public PlayerTeam removeTeam(String name) {
        PlayerTeam team = this.teamsByName.remove(name);

        if (team == null) {
            return null;
        }

        for (String player : team.getPlayers()) {
            this.teamsByPlayer.remove(player);
        }

        this.onTeamRemoved(team);
        return team;
    }

    @Override
    public void removeTeam(PlayerTeam team) {
        this.teamsByName.remove(team.getName());

        for (String player : team.getPlayers()) {
            this.teamsByPlayer.remove(player);
        }

        this.onTeamRemoved(team);
    }

    @Override
    public PlayerTeam getOrAddTeam(String name) {
        PlayerTeam team = this.getTeam(name);

        if (team == null) {
            team = new PlayerTeam((Scoreboard)(Object)this, name);
            this.addTeam(team);
        }

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
    public abstract void onObjectiveAdded(Objective objective);

    @Shadow
    public abstract void onObjectiveRemoved(Objective objective);

    @Shadow
    public abstract void onTeamAdded(PlayerTeam team);

    @Shadow
    public abstract void onTeamRemoved(PlayerTeam team);
}
