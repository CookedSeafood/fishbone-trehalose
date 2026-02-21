package net.hederamc.fishbonetrehalose.api;

import net.minecraft.world.entity.EntityType;

public interface EntityTypeHolder {
    default EntityType<?> type() {
        throw new UnsupportedOperationException();
    }
}
