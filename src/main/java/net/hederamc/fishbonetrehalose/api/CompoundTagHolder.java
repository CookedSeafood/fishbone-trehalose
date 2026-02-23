package net.hederamc.fishbonetrehalose.api;

import net.minecraft.nbt.CompoundTag;

public interface CompoundTagHolder {
    default CompoundTag getTag() {
        throw new UnsupportedOperationException();
    }

    default void setTag(CompoundTag tag) {
        throw new UnsupportedOperationException();
    }
}
