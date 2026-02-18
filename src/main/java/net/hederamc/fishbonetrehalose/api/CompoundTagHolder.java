package net.hederamc.fishbonetrehalose.api;

import net.minecraft.nbt.CompoundTag;

public interface CompoundTagHolder {
    default CompoundTag tag() {
        throw new UnsupportedOperationException();
    }
}
