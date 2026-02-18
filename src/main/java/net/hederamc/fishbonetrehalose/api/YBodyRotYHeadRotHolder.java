package net.hederamc.fishbonetrehalose.api;

public interface YBodyRotYHeadRotHolder {
    default float getYBodyRot(float partialTickTime) {
        throw new UnsupportedOperationException();
    }

    default float getYHeadRot(float partialTickTime) {
        throw new UnsupportedOperationException();
    }

    default void setYBodyRot(float yBodyRot) {
        throw new UnsupportedOperationException();
    }

    default void setYHeadRot(float yHeadRot) {
        throw new UnsupportedOperationException();
    }
}
