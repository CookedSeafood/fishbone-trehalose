package net.hederamc.fishbonetrehalose.api;

public interface NetworkIdHolder {
    default int getNetworkId() {
        throw new UnsupportedOperationException();
    }

    default void setNetworkId(int id) {
        throw new UnsupportedOperationException();
    }
}
