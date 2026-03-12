package net.hederamc.fishbonetrehalose.api;

public interface Passenger {
    default boolean isRiding() {
        throw new UnsupportedOperationException();
    }

    default boolean isRiding(Vehicle vehicle) {
        throw new UnsupportedOperationException();
    }

    default boolean startRiding(Vehicle vehicle) {
        throw new UnsupportedOperationException();
    }

    default void stopRiding() {
        throw new UnsupportedOperationException();
    }
}
