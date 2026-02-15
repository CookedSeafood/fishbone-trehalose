package net.hederamc.fishbonetrehalose.api;

import java.util.Set;
import net.minecraft.world.item.component.CustomData;

public interface EntityApi {
    default double getX(float partialTickTime) {
        throw new UnsupportedOperationException();
    }

    default double getY(float partialTickTime) {
        throw new UnsupportedOperationException();
    }

    default double getZ(float partialTickTime) {
        throw new UnsupportedOperationException();
    }

    default Set<String> getTags() {
        throw new UnsupportedOperationException();
    }

    default boolean hasTag(String tag) {
        throw new UnsupportedOperationException();
    }

    default CustomData getCustomData() {
        throw new UnsupportedOperationException();
    }

    default CustomData getOrCreateCustomData() {
        throw new UnsupportedOperationException();
    }

    default void setCustomData(CustomData customData) {
        throw new UnsupportedOperationException();
    }
}
