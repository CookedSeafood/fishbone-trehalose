package net.hederamc.fishbonetrehalose.api;

public interface Passenger {
    default boolean startRiding(Vehicle vehicle) {
        throw new UnsupportedOperationException();
    }

    default void stopRiding() {
        throw new UnsupportedOperationException();
    }
}
