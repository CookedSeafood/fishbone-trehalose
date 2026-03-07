package net.hederamc.fishbonetrehalose.api;

public interface Vehicle {
    default void addPassenger(Passenger passenger) {
        throw new UnsupportedOperationException();
    }

    default void removePassenger(Passenger passenger) {
        throw new UnsupportedOperationException();
    }
}
