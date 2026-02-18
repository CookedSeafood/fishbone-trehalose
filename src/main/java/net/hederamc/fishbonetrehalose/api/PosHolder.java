package net.hederamc.fishbonetrehalose.api;

import net.minecraft.world.phys.Vec3;

public interface PosHolder {
    default double getX(float partialTickTime) {
        throw new UnsupportedOperationException();
    }

    default double getY(float partialTickTime) {
        throw new UnsupportedOperationException();
    }

    default double getZ(float partialTickTime) {
        throw new UnsupportedOperationException();
    }

    default Vec3 getPos(float partialTickTime) {
        throw new UnsupportedOperationException();
    }

    default void setX(double x) {
        throw new UnsupportedOperationException();
    }

    default void setY(double y) {
        throw new UnsupportedOperationException();
    }

    default void setZ(double z) {
        throw new UnsupportedOperationException();
    }

    default void setPos(Vec3 pos) {
        throw new UnsupportedOperationException();
    }

    default void setPos(double x, double y, double z) {
        throw new UnsupportedOperationException();
    }
}
