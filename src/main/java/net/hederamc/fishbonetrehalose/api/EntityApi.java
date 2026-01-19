package net.hederamc.fishbonetrehalose.api;

import java.util.Set;

public interface EntityApi {
    default double getX(float partialTickTime) {
        return 0.0;
    }

    default double getY(float partialTickTime) {
        return 0.0;
    }

    default double getZ(float partialTickTime) {
        return 0.0;
    }

    default Set<String> getTags() {
        return null;
    }

    default boolean hasTag(String commandTag) {
        return false;
    }
}
