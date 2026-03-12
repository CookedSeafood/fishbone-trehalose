package net.hederamc.fishbonetrehalose.api;

public interface Vehicle {
    default boolean hasPassenger() {
        throw new UnsupportedOperationException();
    }

    default boolean hasPassenger(Passenger passenger) {
        throw new UnsupportedOperationException();
    }

    default void addPassenger(Passenger passenger) {
        throw new UnsupportedOperationException();
    }

    default void removePassenger(Passenger passenger) {
        throw new UnsupportedOperationException();
    }
}
