package net.hederamc.fishbonetrehalose.api;

import java.util.Set;

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

    default boolean hasTag(String commandTag) {
        throw new UnsupportedOperationException();
    }
}
