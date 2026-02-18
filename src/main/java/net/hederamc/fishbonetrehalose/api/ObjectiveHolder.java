package net.hederamc.fishbonetrehalose.api;

import java.util.List;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.numbers.NumberFormat;
import net.minecraft.world.scores.Objective;
import net.minecraft.world.scores.criteria.ObjectiveCriteria;
import net.minecraft.world.scores.criteria.ObjectiveCriteria.RenderType;
import org.jspecify.annotations.Nullable;

public interface ObjectiveHolder {
    default boolean containsObjective(String name) {
        throw new UnsupportedOperationException();
    }

    @Nullable
    default Objective getObjective(String name) {
        throw new UnsupportedOperationException();
    }

    default Objective addObjective(String name, ObjectiveCriteria criteria, Component displayName,
            RenderType renderType, boolean displayAutoUpdate, @Nullable NumberFormat numberFormat) {
        throw new UnsupportedOperationException();
    }

    default Objective getOrAddObjective(String name, ObjectiveCriteria criteria, Component displayName,
            RenderType renderType, boolean displayAutoUpdate, @Nullable NumberFormat numberFormat) {
        Objective objective = this.getObjective(name);

        if (objective == null) {
            objective = this.addObjective(name, criteria, displayName,
                    renderType, displayAutoUpdate, numberFormat);
        }

        return objective;
    }

    @Nullable
    default Objective removeObjective(String name) {
        throw new UnsupportedOperationException();
    }

    default void removeObjective(Objective objective) {
        throw new UnsupportedOperationException();
    }

    default List<Objective> getObjectives(ObjectiveCriteria criteria) {
        throw new UnsupportedOperationException();
    }
}
