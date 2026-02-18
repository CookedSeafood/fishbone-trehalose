package net.hederamc.fishbonetrehalose.api;

public interface DeadHolder {
    default boolean isDead() {
        throw new UnsupportedOperationException();
    }

    default void setDead(boolean dead) {
        throw new UnsupportedOperationException();
    }
}
